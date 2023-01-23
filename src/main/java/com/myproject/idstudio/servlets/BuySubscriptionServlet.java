package com.myproject.idstudio.servlets;

import com.myproject.idstudio.dao.SubscriptionDao;
import com.myproject.idstudio.models.Customer;
import com.myproject.idstudio.models.Subscription;
import com.myproject.idstudio.models.enums.SubscriptionType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;

@WebServlet("/subscribing")
public class BuySubscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("subscription-preset")==null) {
            String subscriptionPreset = request.getParameter("subscription-preset");
            if (subscriptionPreset == null || subscriptionPreset.equals("")) subscriptionPreset = "standard";
            request.getSession().setAttribute("subscription-preset", subscriptionPreset);
        }
        request.getRequestDispatcher("/WEB-INF/view/buySubscription.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer(
                request.getParameter("first_name").trim(),
                request.getParameter("last_name").trim(),
                request.getParameter("tel_number").trim(),
                request.getParameter("email").trim()
        );
        SubscriptionType subscriptionType;
        try {
            subscriptionType = SubscriptionType.valueOf(request.getParameter("type").toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = Date.from(LocalDate.now().plusMonths(Integer.parseInt(request.getParameter("term"))
        ).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<Subscription>> errors = validatorFactory.getValidator().validate(new Subscription(
                customer, subscriptionType, startDate, endDate
        ));

        if(errors.isEmpty()) {
            try {
                SubscriptionDao.getInstance().putSubscription(
                        new Subscription(customer, subscriptionType, startDate, endDate));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.getSession().removeAttribute("subscription-preset");
            response.sendRedirect(request.getContextPath() + "/");
        }
        else {
            String subscriptionErrorMessage = String.join("<br>",
                    errors.stream().map(error -> error.getMessage()).toList());
            request.getSession().setAttribute("subscriptionErrorMessage", subscriptionErrorMessage);
            request.getSession().setAttribute("subscription-preset", request.getParameter("type"));

            doGet(request, response);
            request.getSession().removeAttribute("subscriptionErrorMessage");
        }
        validatorFactory.close();
    }
}

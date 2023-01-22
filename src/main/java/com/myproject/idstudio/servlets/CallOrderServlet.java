package com.myproject.idstudio.servlets;

import java.io.IOException;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;;
import com.myproject.idstudio.dao.CallDao;
import com.myproject.idstudio.dao.CustomerDao;
import com.myproject.idstudio.models.Call;
import com.myproject.idstudio.models.Customer;

@WebServlet("/order-call")
public class CallOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/orderCall.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = new Customer(request.getParameter("name").trim(), "",
                request.getParameter("number").trim(), "");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Customer>> errors = new HashSet<>();
        errors.addAll(validator.validateProperty(customer, "firstName"));
        errors.addAll(validator.validateProperty(customer, "telNumber"));
        if(errors.isEmpty()) {
            try {
                CallDao.getInstance().addCall(new Call(customer));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect(request.getContextPath() + "/");
        }
        else {
            String callOrderErrorMessage = String.join("<br>",
                    errors.stream().map(error -> error.getMessage()).toList());
            session.setAttribute("callOrderErrorMessage", callOrderErrorMessage);
            doGet(request, response);
            session.removeAttribute("callOrderErrorMessage");
        }
        validatorFactory.close();
    }
}

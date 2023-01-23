package com.myproject.idstudio.servlets;

import com.myproject.idstudio.dao.SubscriptionDao;
import com.myproject.idstudio.models.Subscription;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/show-subscription")
public class SubscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Subscription subscription;
        try {
            subscription = SubscriptionDao.getInstance().getSubscription(
                    Integer.parseInt(request.getParameter("customer-id")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute("subscription", subscription);
        request.getRequestDispatcher("/WEB-INF/view/admin/subscription.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

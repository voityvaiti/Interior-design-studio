package com.myproject.idstudio.servlets;

import com.myproject.idstudio.dao.CustomerDao;
import com.myproject.idstudio.dao.SubscriptionDao;
import com.myproject.idstudio.models.Customer;
import com.myproject.idstudio.models.Subscription;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/show-customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer;
        int customerId = Integer.parseInt(request.getParameter("id"));

        boolean subscriptionExists;

        try {
            customer = CustomerDao.getInstance().getSpecificCustomer(customerId);
            subscriptionExists = SubscriptionDao.getInstance().subscriptionExists(customerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute("subscription-exists", subscriptionExists);
        request.getSession().setAttribute("customer", customer);
        request.getRequestDispatcher("/WEB-INF/view/admin/customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

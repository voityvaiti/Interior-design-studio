package com.webapp.business_card.servlets;

import com.webapp.business_card.dao.CustomerDao;
import com.webapp.business_card.models.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/showCustomer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer(null, null, null);
        try {
            customer = CustomerDao.getInstance().getExactCustomer(
                    Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute("customer", customer);
        request.getRequestDispatcher("WEB-INF/view/customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

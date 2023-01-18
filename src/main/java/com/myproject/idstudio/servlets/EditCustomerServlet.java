package com.myproject.idstudio.servlets;

import com.myproject.idstudio.dao.CallDao;
import com.myproject.idstudio.dao.CustomerDao;
import com.myproject.idstudio.models.Call;
import com.myproject.idstudio.models.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

@WebServlet("/admin/edit-customer")
public class EditCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer;
        try {
            customer = CustomerDao.getInstance().getSpecificCustomer(
                    Integer.parseInt(request.getParameter("customerIdToEdit")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute("customerToEdit", customer);
        request.getRequestDispatcher("/WEB-INF/view/editCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerIdToEdit"));
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String telNumber = request.getParameter("telNumber");

            try {
                CustomerDao.getInstance().forceUpdateCustomer(new Customer(customerId, firstName, lastName, telNumber));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect(request.getContextPath() + "/admin/show-customer?id=" + customerId);
    }
}

package com.myproject.idstudio.servlets;

import com.myproject.idstudio.dao.CustomerDao;
import com.myproject.idstudio.models.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/edit-customer")
public class CustomerEditingServlet extends HttpServlet {
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
        request.getRequestDispatcher("/WEB-INF/view/admin/editCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerIdToEdit"));
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String email = request.getParameter("email").trim();
        String telNumberBeforeEdit = request.getParameter("telNumberBeforeEdit").trim();
        String telNumberAfterEdit = request.getParameter("telNumberAfterEdit").trim();

        CustomerDao customerDao = CustomerDao.getInstance();
        String editCustomerErrorMessage;

        try {
            boolean customerAlreadyExist = customerDao.customerExists(telNumberAfterEdit);
            boolean customerWasChanged = !telNumberBeforeEdit.equals(telNumberAfterEdit);

            if(customerAlreadyExist && customerWasChanged) {
                editCustomerErrorMessage = "Customer with same telephone number is already exist";
                request.getSession().setAttribute("editCustomerErrorMessage", editCustomerErrorMessage);
                doGet(request, response);
                request.getSession().removeAttribute("editCustomerErrorMessage");
            } else if (customerAlreadyExist) {
                customerDao.ensureCustomer(new Customer(firstName, lastName, telNumberBeforeEdit,email));
                response.sendRedirect(request.getContextPath() + "/admin/show-customer?id=" + customerId);
            } else if (customerWasChanged) {
                customerDao.forceUpdateCustomer(new Customer(customerId, firstName, lastName, telNumberAfterEdit, email));
                response.sendRedirect(request.getContextPath() + "/admin/show-customer?id=" + customerId);
            } else {
                editCustomerErrorMessage = "Error! Update page and try again";
                request.getSession().setAttribute("editCustomerErrorMessage", editCustomerErrorMessage);
                doGet(request, response);
                request.getSession().removeAttribute("editCustomerErrorMessage");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

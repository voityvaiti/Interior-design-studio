package com.myproject.idstudio.servlets;

import com.myproject.idstudio.dao.CustomerDao;
import com.myproject.idstudio.models.Customer;
import com.myproject.idstudio.security.PageSecurity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/customersList")
public class CustomerListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if(new PageSecurity().isSecure(request, response)) {
                List<Customer> customersList = CustomerDao.getInstance().getCustomers();
                request.getSession().setAttribute("customersList", customersList);
                request.getRequestDispatcher("WEB-INF/view/customersList.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {}
}

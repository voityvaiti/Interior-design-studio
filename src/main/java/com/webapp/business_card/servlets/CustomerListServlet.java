package com.webapp.business_card.servlets;

import com.webapp.business_card.dao.CustomerDao;
import com.webapp.business_card.models.Customer;
import com.webapp.business_card.security.PageSecurity;

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
    private static final long serialVersionUID = 1L;

    public CustomerListServlet() {
        super();
    }
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

package com.myproject.idstudio.servlets;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.idstudio.dao.CallDao;
import com.myproject.idstudio.dao.CustomerDao;

@WebServlet("/admin")
public class AdminPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getSession().setAttribute("customersAmount", CustomerDao.getInstance().countCustomers());
            request.getSession().setAttribute("callOrdersAmount", CallDao.getInstance().countCalls());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/WEB-INF/view/admin/adminPage.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}

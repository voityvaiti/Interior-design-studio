package com.myproject.idstudio.servlets;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.idstudio.dao.CallDao;
import com.myproject.idstudio.models.Call;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Call> list = CallDao.getInstance().getCalls();
            request.getSession().setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CallDao.getInstance().removeCall(Integer.parseInt(request.getParameter("callIdToDelete")));
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }
}

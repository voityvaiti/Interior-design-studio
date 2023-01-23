package com.myproject.idstudio.servlets.call;

import com.myproject.idstudio.dao.CallDao;
import com.myproject.idstudio.models.Call;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/call-order-list")
public class CallOrderListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Call> list = CallDao.getInstance().getCalls();
            request.getSession().setAttribute("callList", list);
            request.getRequestDispatcher("/WEB-INF/view/admin/callOrderList.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CallDao.getInstance().removeCall(Integer.parseInt(request.getParameter("callIdToDelete")));
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }
}

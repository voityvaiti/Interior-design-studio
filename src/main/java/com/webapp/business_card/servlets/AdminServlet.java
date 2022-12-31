package com.webapp.business_card.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.business_card.dao.CallDao;
import com.webapp.business_card.dao.CodeDao;
import com.webapp.business_card.models.Call;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CodeDao codeDao = CodeDao.getInstance();
		try {
			if (request.getSession().getAttribute("code") != null
					&& ((String) request.getSession().getAttribute("code")).equalsIgnoreCase(codeDao.getCode())) {
				List<Call> list = CallDao.getInstance().getCalls();
				request.getSession().setAttribute("list", list);
				request.getRequestDispatcher("WEB-INF/view/admin.jsp").forward(request, response);
			} else
				response.sendRedirect("/Interior-Design-Studio/authn");
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

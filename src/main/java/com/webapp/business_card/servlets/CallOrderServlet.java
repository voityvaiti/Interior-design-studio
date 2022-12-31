package com.webapp.business_card.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.business_card.dao.CallDao;
import com.webapp.business_card.models.Call;
import com.webapp.business_card.validators.CallOrderValidator;

@WebServlet("/order")
public class CallOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CallOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/orderCall.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		session.setAttribute("name", name);
		session.setAttribute("number", number);
		
		CallOrderValidator callOrderValidator = new CallOrderValidator(new Call(name, number));
		if(callOrderValidator.hasErrors()) {
			session.setAttribute("callOrderErrorMessage", callOrderValidator.getErrors());
			doGet(request, response);
			session.removeAttribute("callOrderErrorMessage");
		}
		else {
		try {
			CallDao.getInstance().addCall(new Call(name, number));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/Interior-Design-Studio/");
		}
	}

}

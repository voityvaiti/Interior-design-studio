package com.myproject.idstudio.servlets;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myproject.idstudio.dao.CallDao;
import com.myproject.idstudio.dao.CustomerDao;
import com.myproject.idstudio.models.Call;
import com.myproject.idstudio.models.Customer;
import com.myproject.idstudio.validators.CallOrderValidator;

@WebServlet("/order")
public class CallOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/orderCall.jsp").forward(request, response);
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
			CustomerDao.getInstance().addCustomer(new Customer(name, "", number));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/");
		}
	}

}

package com.webapp.business_card.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.business_card.dao.CodeDao;
import com.webapp.business_card.security.Encryptor;
import com.webapp.business_card.security.PageSecurity;
import com.webapp.business_card.validators.CodeValidator;

@WebServlet("/codeChange")
public class CodeChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CodeChangeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (new PageSecurity().isSecure(request, response)) {
				request.getRequestDispatcher("WEB-INF/view/codeChange.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (new PageSecurity().isSecure(request, response)) {
				HttpSession session = request.getSession();
				String code = request.getParameter("code");
				CodeValidator codeValidator = new CodeValidator(code);
				if (codeValidator.hasErrors()) {
					session.setAttribute("codeChangeErrorMessage", codeValidator.getErrors());
					doGet(request, response);
					session.removeAttribute("codeChangeErrorMessage");
				} else {
					CodeDao.getInstance().updateCode(Encryptor.encrypt(code));
					response.sendRedirect("/Interior-Design-Studio/admin");
				}
			}
		} catch (NoSuchAlgorithmException | SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}

package com.myproject.idstudio.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.idstudio.dao.CodeDao;
import com.myproject.idstudio.security.Encryptor;

@WebServlet("/authn")
public class AuthnServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/authn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String encryptedCode = null;
		try {
			encryptedCode = Encryptor.encrypt(request.getParameter("code"));
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		CodeDao codeDao = CodeDao.getInstance();
		try {
			if (encryptedCode.equalsIgnoreCase(codeDao.getCode())) {
				request.getSession().setAttribute("code", encryptedCode);
				response.sendRedirect("/idstudio/admin");
			} else {
				request.getSession().setAttribute("authnErrorMessage", "Wrong code!");
				doGet(request, response);
				request.getSession().removeAttribute("authnErrorMessage");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.myproject.idstudio.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myproject.idstudio.dao.CodeDao;
import com.myproject.idstudio.security.Encryptor;
import com.myproject.idstudio.validators.CodeValidator;

@WebServlet("/admin/codeChange")
public class CodeChangeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/codeChange.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String code = request.getParameter("code");
            CodeValidator codeValidator = new CodeValidator(code);
            if (codeValidator.hasErrors()) {
                session.setAttribute("codeChangeErrorMessage", codeValidator.getErrors());
                doGet(request, response);
                session.removeAttribute("codeChangeErrorMessage");
            } else {
                CodeDao.getInstance().updateCode(Encryptor.encrypt(code));
                response.sendRedirect(request.getContextPath() + "/admin");
            }
        } catch (NoSuchAlgorithmException | SQLException e) {
            e.printStackTrace();
        }
    }
}

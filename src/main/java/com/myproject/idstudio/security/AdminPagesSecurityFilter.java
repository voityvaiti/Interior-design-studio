package com.myproject.idstudio.security;

import com.myproject.idstudio.dao.CodeDao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AdminPagesSecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        CodeDao codeDao = CodeDao.getInstance();
        String clientSecureCode = (String)((HttpServletRequest) request).
                getSession().getAttribute("code");
        try {
            if(clientSecureCode!=null && clientSecureCode.equalsIgnoreCase(codeDao.getCode())) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse)response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/authn");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

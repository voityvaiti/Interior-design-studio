package com.webapp.business_card.security;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.business_card.dao.CodeDao;

public class PageSecurity {
	
	public boolean isSecure(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		CodeDao codeDao = CodeDao.getInstance();
		String requestSecureCode = (String) request.getSession().getAttribute("code");
		
		if(requestSecureCode!=null && requestSecureCode.equalsIgnoreCase(codeDao.getCode())) 
			return true;
		else {
			response.sendRedirect("/Interior-Design-Studio/authn");
			return false;
		}
	}
}

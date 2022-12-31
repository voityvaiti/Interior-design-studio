package com.webapp.business_card.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CodeDao {
	
	private static CodeDao instance;

	private CodeDao() {
	};

	public static CodeDao getInstance() {
		if (instance == null) {
			instance = new CodeDao();
		}
		return instance;
	}
	
	private Connection connection = DatabaseConnector.getInstance().getConnection();
	
	public String getCode() throws SQLException {
		ResultSet resultSet = connection.createStatement().executeQuery("SELECT code FROM admin_code WHERE id=1");
		System.out.println(connection);
		resultSet.next();
		return resultSet.getString("code");
	}
	
	public void setCode(String code) throws SQLException {
		PreparedStatement preparedStatement = 
				connection.prepareStatement("INSERT INTO admin_code (code) VALUES (?)");
		preparedStatement.setString(1, code);
		preparedStatement.executeUpdate();
	}
}

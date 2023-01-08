package com.myproject.idstudio.dao;

import com.myproject.idstudio.service.DatabaseConnector;

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
		resultSet.next();
		return resultSet.getString("code");
	}
	
	public void updateCode(String code) throws SQLException {
		PreparedStatement preparedStatement = 
				connection.prepareStatement("UPDATE admin_code SET code=? WHERE id=1");
		preparedStatement.setString(1, code);
		preparedStatement.executeUpdate();
	}
}

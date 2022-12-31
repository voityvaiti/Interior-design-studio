package com.webapp.business_card.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
	private static DatabaseConnector instance;

	private DatabaseConnector() {
	};

	public static DatabaseConnector getInstance() {
		if (instance == null) {
			instance = new DatabaseConnector();
		}
		return instance;
	}
	
	private Connection connection;
	
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			Properties dbProperties = new Properties();
			dbProperties.load(DatabaseConnector.class.getClassLoader().getResourceAsStream("db.properties"));
			connection = DriverManager.getConnection(dbProperties.getProperty("URL"), dbProperties);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}


}

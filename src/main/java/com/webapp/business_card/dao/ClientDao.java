package com.webapp.business_card.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.webapp.business_card.models.Client;

public class ClientDao {
	private static ClientDao instance;

	private ClientDao() {
	};

	public static ClientDao getInstance() {
		if (instance == null) {
			instance = new ClientDao();
		}
		return instance;
	}
	
	private Connection connection = DatabaseConnector.getInstance().getConnection();
	
	public void addClient(Client client) throws SQLException {
		PreparedStatement clientCheckStatement = 
				connection.prepareStatement("SELECT * FROM clients WHERE tel_number=?");
		clientCheckStatement.setString(1, client.getTelNumber());
		boolean clientExists =  clientCheckStatement.executeQuery().next();
		if(clientExists) {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("UPDATE clients SET first_name=?, last_name=? WHERE tel_number=?");
			preparedStatement.setString(1, client.getFirstName());
			preparedStatement.setString(2, client.getLastName());
			preparedStatement.setString(3, client.getTelNumber());
			preparedStatement.executeUpdate();
		} else {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("INSERT INTO clients (first_name, last_name, tel_number) VALUES (?, ?, ?)");
			preparedStatement.setString(1, client.getFirstName());
			preparedStatement.setString(2, client.getLastName());
			preparedStatement.setString(3, client.getTelNumber());
			preparedStatement.executeUpdate();
		}
	}
}

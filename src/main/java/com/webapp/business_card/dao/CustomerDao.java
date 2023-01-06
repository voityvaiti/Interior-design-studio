package com.webapp.business_card.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webapp.business_card.models.Customer;

public class CustomerDao {
	private static CustomerDao instance;

	private CustomerDao() {
	};

	public static CustomerDao getInstance() {
		if (instance == null) {
			instance = new CustomerDao();
		}
		return instance;
	}
	
	private Connection connection = DatabaseConnector.getInstance().getConnection();

	public List<Customer> getCustomers() throws SQLException {
		ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM customers");
		List<Customer> customers = new ArrayList<>();

		while(resultSet.next()) {
			Customer customer = new Customer(
					resultSet.getInt("id"),
					resultSet.getString("first_name"),
					resultSet.getString("last_name"),
					resultSet.getString("tel_number")
			);
			customers.add(customer);
		}
		return customers;
	}
	
	public void addCustomer(Customer customer) throws SQLException {
		PreparedStatement customerCheckStatement =
				connection.prepareStatement("SELECT * FROM customers WHERE tel_number=?");
		customerCheckStatement.setString(1, customer.getTelNumber());
		boolean customerExists =  customerCheckStatement.executeQuery().next();
		if(customerExists) {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("UPDATE customers SET first_name=?, last_name=? WHERE tel_number=?");
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getTelNumber());
			preparedStatement.executeUpdate();
		} else {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("INSERT INTO customers (first_name, last_name, tel_number) VALUES (?, ?, ?)");
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getTelNumber());
			preparedStatement.executeUpdate();
		}
	}
}

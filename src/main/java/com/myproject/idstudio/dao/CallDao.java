package com.myproject.idstudio.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.idstudio.models.Call;
import com.myproject.idstudio.models.Customer;
import com.myproject.idstudio.service.DatabaseConnector;

public class CallDao {
	private static CallDao instance;

	private CallDao() {
	};

	public static CallDao getInstance() {
		if (instance == null) {
			instance = new CallDao();
		}
		return instance;
	}
	
	private final Connection connection = DatabaseConnector.getInstance().getConnection();

	public List<Call> getCalls() throws SQLException {
		ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM call_orders");
		List<Call> calls = new ArrayList<>();
		CustomerDao customerDao = CustomerDao.getInstance();
		
		while(resultSet.next()) {
			Customer customer = customerDao.
					getSpecificCustomer(resultSet.getInt("customer_id"));
			Call call = new Call(
					resultSet.getInt("id"),
					customer.getId(),
					customer.getFirstName(),
					customer.getTelNumber()
					);
			calls.add(call);	
		}
		return calls;
	}

	public void addCall(Call call) throws SQLException {
		CustomerDao customerDao = CustomerDao.getInstance();
		customerDao.ensureCustomer(new Customer(call.getName(), "", call.getNumber(), ""));

		PreparedStatement preparedStatement = 
				connection.prepareStatement("INSERT INTO call_orders (customer_id) VALUES (?)");
		preparedStatement.setInt(1, customerDao.getSpecificCustomer(call.getNumber()).getId());
		preparedStatement.executeUpdate();
	}

	public void removeCall(int id) throws SQLException {
		PreparedStatement preparedStatement = 
				connection.prepareStatement("DELETE FROM call_orders WHERE id=?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public int countCalls() throws SQLException {
		ResultSet resultSet =
				connection.createStatement().executeQuery("SELECT COUNT(*) AS amount FROM call_orders");
		resultSet.next();
		return resultSet.getInt("amount");
	}
}

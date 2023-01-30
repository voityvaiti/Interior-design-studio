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
		ResultSet resultSet = connection.createStatement().executeQuery("SELECT call_orders.id AS id, " +
				"customers.id AS customer_id, customers.first_name " +
				"AS name, customers.tel_number AS tel_number " +
				"FROM call_orders JOIN customers ON call_orders.customer_id=customers.id");
		List<Call> calls = new ArrayList<>();
		
		while(resultSet.next()) {
			Call call = new Call(
					resultSet.getInt("id"),
					new Customer(
					resultSet.getInt("customer_id"),
					resultSet.getString("name"), "",
					resultSet.getString("tel_number"), ""
					)
					);
			calls.add(call);	
		}
		return calls;
	}

	public void addCall(Call call) throws SQLException {
		CustomerDao customerDao = CustomerDao.getInstance();
		customerDao.ensureCustomer(call.getCustomer());

		PreparedStatement preparedStatement = 
				connection.prepareStatement("INSERT INTO call_orders (customer_id) VALUES (?)");
		preparedStatement.setInt(1, customerDao.getSpecificCustomer(call.getCustomer().getTelNumber()).getId());
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

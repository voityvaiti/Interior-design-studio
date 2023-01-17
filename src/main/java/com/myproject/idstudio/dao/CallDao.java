package com.myproject.idstudio.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.idstudio.models.Call;
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
		
		while(resultSet.next()) {
			Call call = new Call(
					resultSet.getInt("id"),
					resultSet.getString("name"),
					resultSet.getString("tel_number")
					);
			calls.add(call);	
		}
		return calls;
	}

	public void addCall(Call call) throws SQLException {
		PreparedStatement preparedStatement = 
				connection.prepareStatement("INSERT INTO call_orders (name, tel_number) VALUES (?, ?)");
		preparedStatement.setString(1, call.getName());
		preparedStatement.setString(2, call.getNumber());
		preparedStatement.executeUpdate();
	}

	public void removeCall(int id) throws SQLException {
		PreparedStatement preparedStatement = 
				connection.prepareStatement("DELETE FROM call_orders WHERE id=?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

}

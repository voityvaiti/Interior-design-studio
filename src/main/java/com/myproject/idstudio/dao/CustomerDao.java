package com.myproject.idstudio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.idstudio.service.DatabaseConnector;
import com.myproject.idstudio.models.Customer;

/**
 * In order not to violate the application logic, every customer must have unique telNumber.
 * Methods force..() requires checking existence of customer with same telNumber as customer
 * in method param(e.g. using method (customerExists())
 */
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

    private final Connection connection = DatabaseConnector.getInstance().getConnection();

    public List<Customer> getCustomers() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM customers");
        List<Customer> customers = new ArrayList<>();

        while (resultSet.next()) {
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

    public Customer getSpecificCustomer(int id) throws SQLException {
        PreparedStatement getCustomerStatement =
                connection.prepareStatement("SELECT * FROM customers WHERE id=?");
        getCustomerStatement.setInt(1, id);
        ResultSet customerResultSet = getCustomerStatement.executeQuery();

        customerResultSet.next();
        String firstName = customerResultSet.getString("first_name");
        String lastName = customerResultSet.getString("last_name");
        String telNumber = customerResultSet.getString("tel_number");
        return new Customer(id, firstName, lastName, telNumber);
    }

    public Customer getSpecificCustomer(String telNumber) throws SQLException {
        PreparedStatement getCustomerStatement =
                connection.prepareStatement("SELECT * FROM customers WHERE tel_number=?");
        getCustomerStatement.setString(1, telNumber);
        ResultSet customerResultSet = getCustomerStatement.executeQuery();

        customerResultSet.next();
        int id = customerResultSet.getInt("id");
        String firstName = customerResultSet.getString("first_name");
        String lastName = customerResultSet.getString("last_name");
        return new Customer(id, firstName, lastName, telNumber);
    }

    public void forceAddCustomer(Customer customer) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO customers (first_name, last_name, tel_number) VALUES (?, ?, ?)");
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getTelNumber());
        preparedStatement.executeUpdate();
    }

    public void ensureCustomer(Customer customer) throws SQLException {
        if(customerExists(customer.getTelNumber())) {
            String firstName = customer.getFirstName();
            String lastName = customer.getLastName();
            String telNumber = customer.getTelNumber();

            if (firstName != null && !firstName.equals("")) {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET first_name=? WHERE tel_number=?");
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, telNumber);
                preparedStatement.executeUpdate();
            }
            if (lastName != null && !lastName.equals("")) {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET last_name=? WHERE tel_number=?");
                preparedStatement.setString(1, lastName);
                preparedStatement.setString(2, telNumber);
                preparedStatement.executeUpdate();
            }
        }
        else forceAddCustomer(customer);
    }

    public void forceUpdateCustomer(Customer customer) throws SQLException {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE customers SET first_name=?, last_name=?, tel_number=?  WHERE id=?");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getTelNumber());
            preparedStatement.setInt(4, customer.getId());
            preparedStatement.executeUpdate();
    }

    public boolean customerExists(String telNumber) throws SQLException {
        PreparedStatement customerCheckStatement =
                connection.prepareStatement("SELECT * FROM customers WHERE tel_number=?");
        customerCheckStatement.setString(1, telNumber);
        return customerCheckStatement.executeQuery().next();
    }

//    Alternative version of method ensureCustomer()
//        public void ensureCustomer(Customer customer) throws SQLException {
//        if (customerExists(customer.getTelNumber())) {
//            String firstName = customer.getFirstName();
//            String lastName = customer.getLastName();
//            String telNumber = customer.getTelNumber();
//
//            boolean firstNameIsPresent = firstName != null && !firstName.equals("");
//            boolean lastNameIsPresent = lastName != null && !lastName.equals("");
//
//            StringBuilder sqlStatementBuilder = new StringBuilder();
//            sqlStatementBuilder.append("UPDATE customers SET");
//
//            List<String> fieldsToUpdate = new ArrayList<>();
//            if (firstName != null && !firstName.equals("")) fieldsToUpdate.add(" first_name=?");
//            if (lastName != null && !lastName.equals("")) fieldsToUpdate.add(" last_name=?");
//            sqlStatementBuilder.append(String.join(",", fieldsToUpdate));
//
//            sqlStatementBuilder.append(", WHERE tel_number=?");
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatementBuilder.toString());
//            int indexOfParam = 0;
//            if (firstNameIsPresent) preparedStatement.setString(++indexOfParam, firstName);
//            if (lastNameIsPresent) preparedStatement.setString(++indexOfParam, lastName);
//            preparedStatement.setString(++indexOfParam, telNumber);
//            preparedStatement.executeQuery();
//        }
//        else addCustomer(customer);
//    }
}

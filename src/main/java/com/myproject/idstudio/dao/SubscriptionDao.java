package com.myproject.idstudio.dao;

import com.myproject.idstudio.models.Customer;
import com.myproject.idstudio.models.Subscription;
import com.myproject.idstudio.models.enums.SubscriptionType;
import com.myproject.idstudio.service.DatabaseConnector;

import java.sql.*;

public class SubscriptionDao {
    private static SubscriptionDao instance;

    private SubscriptionDao() {
    }

    public static SubscriptionDao getInstance() {
        if (instance == null) {
            instance = new SubscriptionDao();
        }
        return instance;
    }

    private final Connection connection = DatabaseConnector.getInstance().getConnection();

    public Subscription getSubscription(int customerId) throws SQLException {
        PreparedStatement getSubscriptionStatement =
                connection.prepareStatement("SELECT subscriptions.id AS id, customers.id AS customer_id, customers.first_name AS first_name," +
                        "customers.last_name AS last_name, customers.tel_number AS tel_number, customers.email AS email, " +
                        "subscriptions.type AS type, subscriptions.start_date AS start_date, subscriptions.end_date AS end_date " +
                        "FROM subscriptions JOIN customers on customer_id=customers.id WHERE customer_id=?");
        getSubscriptionStatement.setInt(1, customerId);
        ResultSet subscriptionResultSet = getSubscriptionStatement.executeQuery();

        if (subscriptionResultSet.next()) {
            int id = subscriptionResultSet.getInt("id");
            Customer customer = new Customer(
                    subscriptionResultSet.getInt("customer_id"),
                    subscriptionResultSet.getString("first_name"),
                    subscriptionResultSet.getString("last_name"),
                    subscriptionResultSet.getString("tel_number"),
                    subscriptionResultSet.getString("email")
            );
            SubscriptionType subscriptionType =
                    SubscriptionType.valueOf(subscriptionResultSet.getString("type"));
            java.util.Date startDate = new java.util.Date(subscriptionResultSet.getDate("start_date").getTime());
            java.util.Date endDate = new java.util.Date(subscriptionResultSet.getDate("end_date").getTime());
            return new Subscription(id, customer, subscriptionType, startDate, endDate);
        } else return null;
    }

    public void putSubscription(Subscription subscription) throws SQLException {
        CustomerDao customerDao = CustomerDao.getInstance();
        customerDao.ensureCustomer(subscription.getCustomer());
        subscription.setCustomer(
                customerDao.getSpecificCustomer(subscription.getCustomer().getTelNumber())
        );

        if (subscriptionExists(subscription.getCustomer().getId())) {
            Subscription existingSubscription = getSubscription(subscription.getCustomer().getId());
            subscription.setId(existingSubscription.getId());
            if (subscription.getSubscriptionType() == existingSubscription.getSubscriptionType()) {
                subscription.setEndDate(
                        new java.util.Date(
                                existingSubscription.getEndDate().getTime()
                                        + (subscription.getEndDate().getTime() - subscription.getStartDate().getTime())
                        )
                );
            }
            updateSubscription(subscription);
        } else
            addSubscription(subscription);
    }

    private void addSubscription(Subscription subscription) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO subscriptions (customer_id, type, start_date, end_date) VALUES (?, ?, ?, ?)");
        preparedStatement.setInt(1, subscription.getCustomer().getId());
        preparedStatement.setString(2, subscription.getSubscriptionType().toString());
        preparedStatement.setDate(3, new Date(subscription.getStartDate().getTime()));
        preparedStatement.setDate(4, new Date(subscription.getEndDate().getTime()));
        preparedStatement.executeUpdate();
    }

    private void updateSubscription(Subscription subscription) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE subscriptions SET type=?, start_date=?, end_date=? WHERE id=?");
        preparedStatement.setString(1, subscription.getSubscriptionType().toString());
        preparedStatement.setDate(2, new Date(subscription.getStartDate().getTime()));
        preparedStatement.setDate(3, new Date(subscription.getEndDate().getTime()));
        preparedStatement.setInt(4, subscription.getId());
        preparedStatement.executeUpdate();
    }

    public boolean subscriptionExists(int customerId) throws SQLException {
        PreparedStatement getSubscriptionStatement =
                connection.prepareStatement("SELECT * FROM subscriptions WHERE customer_id=?");
        getSubscriptionStatement.setInt(1, customerId);
        return getSubscriptionStatement.executeQuery().next();
    }
}

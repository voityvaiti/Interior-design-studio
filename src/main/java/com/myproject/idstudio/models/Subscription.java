package com.myproject.idstudio.models;

import com.myproject.idstudio.models.enums.SubscriptionType;

import javax.validation.Valid;
import java.util.Date;

public class Subscription {
    private int id;
    @Valid
    private Customer customer;
    private SubscriptionType subscriptionType;
    private Date startDate;
    private Date endDate;

    public Subscription(int id, Customer customer, SubscriptionType subscriptionType, Date startDate, Date endDate) {
        this.id = id;
        this.customer = customer;
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Subscription(Customer customer, SubscriptionType subscriptionType, Date startDate, Date endDate) {
        this.customer = customer;
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}


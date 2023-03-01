<%@ page import="com.myproject.idstudio.models.Subscription" %>
<%@ page import="com.myproject.idstudio.models.Customer" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../styles/subscription-page/subscription.css">
    <title>Subscription Details</title>
</head>

<body>
<% Subscription subscription = (Subscription) request.getSession().getAttribute("subscription");
    Customer customer = subscription.getCustomer();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    long subscriptionTermMillisLeft = subscription.getEndDate().getTime() - new Date(System.currentTimeMillis()).getTime();
    int subscriptionTermDaysLeft = (int)TimeUnit.MILLISECONDS.toDays(subscriptionTermMillisLeft);
%>

<div class="outer-container row mx-0">
    <div class="inner-container col-10 col-sm-8 col-md-6">
        <a class="return-link" href="<%=request.getContextPath()%>/admin/show-customer?id=<%=subscription.getCustomer().getId()%>">← Back</a>
        <div class="header-container">
            <h1>Subscription <span>#<%= subscription.getId() %> </span></h1>
            <h2
                <% if(subscriptionTermDaysLeft>=0) { %> style="color: green">Active, <%=subscriptionTermDaysLeft%> days left<%} %>
                <% if(subscriptionTermDaysLeft<0) { %> style="color: red">Expired <%=subscriptionTermDaysLeft *-1%> days ago<%} %>
            </h2>
        </div>
        <div class="info-container">
            <div class="customer-info-container">
                <h3><span>Customer</span> Info</h3>
                <ul>
                    <li>First name: <%=customer.getFirstName()%></li>
                    <li>Last name: <%=customer.getLastName()%></li>
                    <li>Telephone number: <%=customer.getTelNumber()%></li>
                    <li>E-mail: <%=customer.getEmail()%></li>
                </ul>
            </div>
            <div class="subscription-info-container">
                <h3><span>Subscription</span> Info</h3>
                <ul>
                    <li>Type: <%=subscription.getSubscriptionType().toString()%></li>
                    <li>Start date: <%=dateFormat.format(subscription.getStartDate())%></li>
                    <li>End date: <%=dateFormat.format(subscription.getEndDate())%></li>
                </ul>
            </div>
        </div>
    </div>
</div>

</body>

</html>

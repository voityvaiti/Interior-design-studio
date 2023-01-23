<%@ page import="com.myproject.idstudio.models.Subscription" %>
<%@ page import="com.myproject.idstudio.models.Customer" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscription details</title>
</head>
<body>
<% Subscription subscription = (Subscription) request.getSession().getAttribute("subscription");
    Customer customer = subscription.getCustomer();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    long subscriptionTermMillisLeft = subscription.getEndDate().getTime() - new Date(System.currentTimeMillis()).getTime();
    int subscriptionTermDaysLeft = (int)TimeUnit.MILLISECONDS.toDays(subscriptionTermMillisLeft);
%>
<a href="<%=request.getContextPath()%>/admin/show-customer?id=<%=subscription.getCustomer().getId()%>">Back</a>
<h1>Subscription #<%= subscription.getId() %> </h1>
<h2
    <% if(subscriptionTermDaysLeft>=0) { %> style="color: green">Active, <%=subscriptionTermDaysLeft%> days left<%} %>
    <% if(subscriptionTermDaysLeft<0) { %> style="color: red">Expired <%=subscriptionTermDaysLeft *-1%> days ago<%} %>
</h2>
<h3>Customer info:</h3>
<p>First name: <%=customer.getFirstName()%></p>
<p>Last name: <%=customer.getLastName()%></p>
<p>Telephone number: <%=customer.getTelNumber()%></p>
<p>E-mail: <%=customer.getEmail()%></p>
<h3>Subscription info:</h3>
<p>Type: <%=subscription.getSubscriptionType().toString()%></p>
<p>Start date: <%=dateFormat.format(subscription.getStartDate())%></p>
<p>End date: <%=dateFormat.format(subscription.getEndDate())%></p>
<p></p>

</body>
</html>

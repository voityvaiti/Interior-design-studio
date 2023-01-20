<%@ page import="com.myproject.idstudio.models.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer details</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/admin/customers-list">Back</a>
<% Customer customer = (Customer)request.getSession().getAttribute("customer"); %>
<h1>Customer #<%= customer.getId() %> </h1>
<p>First name: <%=customer.getFirstName()%></p>
<p>Last name: <%=customer.getLastName()%></p>
<p>Telephone number: <%=customer.getTelNumber()%></p>
<p>E-mail: <%=customer.getEmail()%></p>
<a href="<%=request.getContextPath()%>/admin/edit-customer?customerIdToEdit=<%=customer.getId()%>">Edit</a>
</body>
</html>

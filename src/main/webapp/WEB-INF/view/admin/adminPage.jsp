<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>
<h1>Hello, admin</h1>
<a href="<%=request.getContextPath()%>/admin/customers-list">List of customers</a><br>
<a href="<%=request.getContextPath()%>/admin/call-order-list">List of call orders</a>

</body>
</html>
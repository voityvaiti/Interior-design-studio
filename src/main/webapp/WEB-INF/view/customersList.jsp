<%@ page import="com.myproject.idstudio.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of customers</title>
</head>
<body>
<h1>Customers:</h1>
<%
  List<Customer> list = (ArrayList<Customer>) request.getSession().getAttribute("customersList");
  if(list.size()<=0){%>
<p>No customers yet</p>
<%
}
else {
  for(int i = 0; i< list.size(); i++) {%>
<a href="<%=request.getContextPath()%>/admin/showCustomer?id=<%= list.get(i).getId() %>">
    <%= list.get(i)%> </a>
<br>
<% }}%>
</body>
</html>

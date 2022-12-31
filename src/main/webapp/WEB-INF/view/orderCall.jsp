<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order call</title>
</head>
<body>
<%
String name = "";
if(session.getAttribute("name")!=null) name = (String)session.getAttribute("name");
String number = "";
if(session.getAttribute("number")!=null) number = (String)session.getAttribute("number");
%>
<form name="orderCall" method="post" action="order">
<h3>Please fill in the fields</h3>
    Name: <input type="text" name="name" value="<%=name%>"/> <br/>
    Telephone number: <input type="text" name="number" value="<%=number%>" /> <br/>
    <input type="submit" value="Send" />
</form>
<%if(session.getAttribute("callOrderErrorMessage")!=null) { %> 
<p style="color:red"><%= session.getAttribute("callOrderErrorMessage") %></p>
<%} %>
</body>
</html>
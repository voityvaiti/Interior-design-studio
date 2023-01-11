<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.myproject.idstudio.models.Call" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>
<h1>Hello, admin</h1>
<a href="/idstudio/admin/codeChange">Change code</a><br>
<a href="/idstudio/admin/customersList">List of customers</a>
<h3>Calls:</h3>
<%
List<Call> list = (ArrayList<Call>) request.getSession().getAttribute("list"); 
if(list.size()<=0){%>
	<p>No call orders yet</p>
<% 
}
else {
for(int i = 0; i< list.size(); i++) {%> 
<%= list.get(i) %> 
<form name="deleteCallOrder" method="post" action="admin">
<input type="hidden" name="callIdToDelete" value="<%= list.get(i).getId() %>"/>
<input type="submit" value="Done" />
</form>
<br>
<% }}%>
</body>
</html>
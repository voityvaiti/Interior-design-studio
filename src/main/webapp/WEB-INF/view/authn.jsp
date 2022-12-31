<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin authorization</title>
</head>
<body>
<form name="authnForm" method="post" action="authn">
    Enter code: <input type="password" name="code"/> <br/>
    <input type="submit" value="Send" />
</form>
<%if(request.getSession().getAttribute("authnErrorMessage")!=null) { %> 
<p style="color:red"><%= request.getSession().getAttribute("authnErrorMessage") %></p>
<%} %>
</body>
</html>
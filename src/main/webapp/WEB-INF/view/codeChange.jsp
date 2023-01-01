<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code change</title>
</head>
<body>
<form name="codeChangeForm" method="post" action="codeChange">
    Enter new code: <input type="password" name="code"/> <br/>
    <input type="submit" value="Send" />
</form>
<%if(request.getSession().getAttribute("codeChangeErrorMessage")!=null) { %> 
<p style="color:red"><%= request.getSession().getAttribute("codeChangeErrorMessage") %></p>
<%} %>
</body>
</html>
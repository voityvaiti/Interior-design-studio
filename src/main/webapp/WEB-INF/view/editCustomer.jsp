<%@ page import="com.myproject.idstudio.models.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<% Customer customer = (Customer)request.getSession().getAttribute("customerToEdit"); %>
<h1>Customer #<%= customer.getId() %> </h1>
<p>Telephone number: <%=customer.getTelNumber()%></p><br>
<form name="orderCall" method="post" action="edit-customer">
  <input type="hidden" name="customerIdToEdit" value="<%= customer.getId() %>"/>
  <input type="hidden" name="telNumber" value="<%= customer.getTelNumber() %>"/>
  First name: <input name="firstName" type="text" maxlength="20" value="<%=customer.getFirstName()%>"/><br>
  Last name: <input name="lastName" type="text" maxlength="20" value="<%=customer.getLastName()%>"/><br>
  <input type="submit" value="Edit">
</form>
<%if (session.getAttribute("editCustomerErrorMessage") != null) { %>
<p style="color:red">
  <%= session.getAttribute("editCustomerErrorMessage") %>
</p>
<%} %>
</body>
</html>

<%@ page import="com.myproject.idstudio.models.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<% Customer customer = (Customer)request.getSession().getAttribute("customerToEdit"); %>
<a href="<%=request.getContextPath()%>/admin/show-customer?id=<%=customer.getId()%>">Back</a>
<h1>Customer #<%= customer.getId() %> </h1>
<form name="orderCall" method="post" action="edit-customer">
  <input type="hidden" name="customerIdToEdit" value="<%= customer.getId() %>"/>
  <input type="hidden" name="telNumberBeforeEdit" value="<%= customer.getTelNumber() %>"/>
  Telephone number: <input name="telNumberAfterEdit" type="text" maxlength="16" value="<%= customer.getTelNumber() %>"/><br>
  First name: <input name="firstName" type="text" maxlength="20" value="<%=customer.getFirstName()%>"/><br>
  Last name: <input name="lastName" type="text" maxlength="20" value="<%=customer.getLastName()%>"/><br>
  E-mail: <input name="email" type="text" maxlength="255" value="<%=customer.getEmail()%>"><br>
  <input type="submit" value="Edit">
</form>
<%if (session.getAttribute("editCustomerErrorMessage") != null) { %>
<p style="color:red">
  <%= session.getAttribute("editCustomerErrorMessage") %>
</p>
<%} %>
</body>
</html>

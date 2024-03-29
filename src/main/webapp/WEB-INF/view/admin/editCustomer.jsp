<%@ page import="com.myproject.idstudio.models.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="../styles/edit-customer-page/edit-customer.css">
  <title>Edit Customer</title>
</head>

<body>
<% Customer customer = (Customer)request.getSession().getAttribute("customerToEdit"); %>
<div class="form-container row mx-0">
  <form class="form col-10 col-sm-8 col-md-6 col-lg-4" name="orderCall" method="post" action="edit-customer">
    <a class="return-link" href="<%=request.getContextPath()%>/admin/show-customer?id=<%=customer.getId()%>">← Back</a>
    <h1>Customer <span>#<%= customer.getId() %> </span></h1>
    <input type="hidden" name="customerIdToEdit" value="<%= customer.getId() %>" />
    <input type="hidden" name="telNumberBeforeEdit" value="<%= customer.getTelNumber() %>" />
    <div class="user-info-container">
      <div class="user-info">
        <p class="mb-0">First name: </p>
        <input name="firstName" type="text" maxlength="20" value="<%=customer.getFirstName()%>" id="first-name" />
      </div>
      <div class="user-info">
        <p class="mb-0">Last name: </p>
        <input name="lastName" type="text" maxlength="20" value="<%=customer.getLastName()%>" id="last-name" />
      </div>
      <div class="user-info">
        <p class="mb-0">Phone number: </p>
        <input name="telNumberAfterEdit" type="text" maxlength="16" value="<%= customer.getTelNumber() %>"
               id="number" />
      </div>
      <div class="user-info">
        <p class="mb-0">Email: </p>
        <input name="email" type="text" maxlength="255" value="<%=customer.getEmail()%>" id="email">
      </div>
    </div>
    <input class="submit-button" type="submit" value="EDIT">
    <%if (session.getAttribute("editCustomerErrorMessage") != null) { %>
    <p class="error-message">
      <%= session.getAttribute("editCustomerErrorMessage") %>
    </p>
    <%} %>
  </form>
</div>
</body>

</html>
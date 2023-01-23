<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscribing</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/">Back</a>
<h1>Please, fill in the fields</h1>
<form name="buy_subscription" method="post" action="subscribing">
    First name: <input type="text" name="first_name" maxlength="20"/><br/>
    Last name: <input type="text" name="last_name" maxlength="20"/><br/>
    Telephone number: <input type="tel" name="tel_number" maxlength="16"><br>
    E-mail: <input type="email" name="email" maxlength="255">
    <hr>
    <% String subscriptionType = request.getSession().getAttribute("subscription-preset").toString(); %>
    Subscription: <br>
    <input type="radio" id="basic" name="type" value="basic" <% if (subscriptionType.equals("basic")) {%> <%="checked=\"checked\""%><%} %>>
    <label for="basic">Basic</label><br>
    <input type="radio" id="standard" name="type" value="standard" <% if (subscriptionType.equals("standard")) {%> <%="checked=\"checked\""%><%} %>>
    <label for="standard">Standard</label><br>
    <input type="radio" id="premium" name="type" value="premium" <% if (subscriptionType.equals("premium")) {%> <%="checked=\"checked\""%><%} %>>
    <label for="premium">Premium</label><br>
    Term: <br>
    <input type="number" name="term" min="1" max="12" value="3"> months<br>
    <input type="submit" value="Subscribe">
</form>
<%if (session.getAttribute("subscriptionErrorMessage") != null) { %>
<p style="color:red">
    <%= session.getAttribute("subscriptionErrorMessage") %>
</p>
<%} %>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subscribing</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/subscription-page/subscription.css">
</head>

<body>
<div class="form-container row px-0 mx-0">
    <form class="form col-10 col-sm-8 col-md-6 col-lg-4" name="buy_subscription" method="post" action="subscribing">
        <a class="return-link" href="<%=request.getContextPath()%>/">
            <button class="return-button">← Back</button>
        </a>
        <div class="header-container">
            <h1>Buy <span>Subscription</span></h1>
            <p>Please, fill in the fields</p>
        </div>
        <div class="user-info-container">
            <div class="user-info">
                <input class="input-field" type="text" name="first_name" maxlength="20" id="first-name" />
                <label class="first-name-label" for="first-name">First name</label>
            </div>
            <div class="user-info">
                <input class="input-field" type="text" name="last_name" maxlength="20" id="last-name" />
                <label class="last-name-label" for="last-name">Last name</label>
            </div>
            <div class="user-info">
                <input class="input-field" type="tel" name="tel_number" maxlength="16" id="phone-number">
                <label class="phone-number-label" for="phone-number">Phone number</label>
            </div>
            <div class="user-info">
                <input class="input-field" type="email" name="email" maxlength="255" id="email">
                <label class="email-label" for="email">Email</label>
            </div>
        </div>
        <% String subscriptionType = request.getSession().getAttribute("subscription-preset").toString(); %>
        <div class="subscribing-type-container">
            <div class="subscribing-type">
                <input type="radio" id="basic" name="type" value="basic" <% if (subscriptionType.equals("basic")) {%> <%="checked=\"checked\""%><%} %>>
                <label for="basic">Basic</label>
            </div>
            <div class="subscribing-type">
                <input type="radio" id="standard" name="type" value="standard" <% if (subscriptionType.equals("standard")) {%> <%="checked=\"checked\""%><%} %>>
                <label for="standard">Standard</label>
            </div>
            <div class="subscribing-type">
                <input type="radio" id="premium" name="type" value="premium" <% if (subscriptionType.equals("premium")) {%> <%="checked=\"checked\""%><%} %>>
                <label for="premium">Premium</label>
            </div>
        </div>
        <div class="term-container">
            <p>Term:</p>
            <div class="term-input-container">
                <input type="number" name="term" min="1" max="12" value="3"> <span>months</span>
            </div>
        </div>
        <div class="subscribe-button-container">
            <input type="submit" value="SUBSCRIBE">
        </div>
        <%if (session.getAttribute("subscriptionErrorMessage") !=null) { %>
        <p style="color:red">
            <%= session.getAttribute("subscriptionErrorMessage") %>
        </p>
        <%} %>
    </form>
</div>
<script src="js/subscription-page/animations/subscription.js"></script>
</body>

</html>

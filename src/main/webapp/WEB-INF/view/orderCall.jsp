<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/form/form.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/6.4.1/css/intlTelInput.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <title>Order A Call</title>
  </head>

  <form class="form" name="orderCall" method="post" action="order-call">
    <h1 class="order-a-call-header">Order a <span>Call</span></h1>
    <h3 class="fill-the-fields">Please <span>fill in the fields </span>and<br> we will call you back <br> within
      <span>30 seconds!</span>
    </h3>
    <div class="form-input-container row mx-0">
      <div class="form-name-container col-12 px-0">
        <input class="input-field" type="text" id="name" name="name" value="" maxlength="20" />
        <label class="name-label" for="name">Name</label>
      </div>
      <div class="form-phone-number-container col-12 px-0">
        <input class="input-field number-input" type="tel" id="number" name="number" value="" maxlength="16" />
        <label class="number-label" for="number"> Phone number</label>
        <span id="valid-message" class="hide">? Valid</span>
        <span id="error-message" class="hide">Invalid number</span>
      </div>
      <div class="submit-button-container col-12 px-0">
        <button class="submit-button" type="submit">SEND</button>
      </div>
      <%if (session.getAttribute("callOrderErrorMessage") !=null) { %>
        <p style="color:red">
          <%= session.getAttribute("callOrderErrorMessage") %>
        </p>
        <%} %>
    </div>
  </form>

	<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/6.4.1/js/intlTelInput.min.js"></script>
	<script src="js/order-call-page/animations/order-call/orderCall.js" defer></script>
	<script src="js/order-call-page/helpers/saveUserInfo.js"></script>
  </body>

  </html>
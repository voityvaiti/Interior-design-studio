<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles/order-call-page/order-call.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/6.4.1/css/intlTelInput.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
  <title>Order A Call</title>
</head>

<body>
<div class="form-container row px-0 mx-0">
  <form class="form col-10 col-sm-8 col-md-6 col-lg-4" name="orderCall" method="post" action="order-call">
    <a href="<%=request.getContextPath()%>/" class="return-link">← Back</a>
    <div class="header-container">
      <h1 class="order-a-call-header">Order a <span>Call</span></h1>
      <p class="fill-the-fields">Please <span>fill in the fields </span>and<br> we will call you back <br> within
        <span>30 seconds!</span>
    </div>
  </>
  <div class="form-input-container row mx-0">
    <div class="form-name-container col-12 px-0">
      <input class="input-field" type="text" value="" id="name" name="name"/>
      <label class="order-call-name-label" for="name">Name</label>
    </div>
    <div class="form-phone-number-container col-12 px-0">
      <input class="input-field number-input" type="tel" value="" id="number" name="number"/>
      <label class="order-call-number-label" for="number"> Phone number</label>
      <span id="valid-message" class="hide">✓ Valid</span>
      <span id="error-message" class="hide">Invalid number</span>
    </div>
    <div class="submit-button-container col-12 px-0">
      <button class="submit-button" type="submit">SUBMIT</button>
    </div>
    <%if (session.getAttribute("callOrderErrorMessage") !=null) { %>
    <p style="color:red">
      <%= session.getAttribute("callOrderErrorMessage") %>
    </p>
    <%} %>
  </div>
  </form>
</div>

<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/6.4.1/js/intlTelInput.min.js"></script>
<script type="module" src="js/order-call-page/animations/orderCall.js" defer></script>
<script type="module" src="js/order-call-page/helpers/saveUserInfo.js"></script>
</body>

</html>
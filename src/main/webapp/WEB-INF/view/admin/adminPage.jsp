<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/admin-page/admin.css">
    <title>Admin Page</title>
</head>

<body>
<div class="outer-container row mx-0">
    <div class="inner-container col-10 col-sm-8 col-md-6 col-lg-4">
        <% Integer customersAmount = (Integer)request.getSession().getAttribute("customersAmount");
            Integer callOrdersAmount = (Integer)request.getSession().getAttribute("callOrdersAmount");%>
        <h1>Hello, <span>Admin</span></h1>
        <h5>Today we have:</h5>
        <p>
            <%=customersAmount%> customer<%if(customersAmount!=1) {%><%="s"%><%}%>
        </p>
        <p>
            <%=callOrdersAmount%> call order<%if(callOrdersAmount!=1) {%><%="s"%><%}%>
        </p>
        <div class="links-container">
            <a href="<%=request.getContextPath()%>/admin/customers-list">
                <button class="list-button">List of Customers</button>
            </a>
            <a href="<%=request.getContextPath()%>/admin/call-order-list">
                <button class="list-button">List of Call Orders</button>
            </a>
        </div>
    </div>
</div>

</body>

</html>
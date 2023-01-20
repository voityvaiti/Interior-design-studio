<%@ page import="com.myproject.idstudio.models.Call" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calls list</title>
</head>
<body>
<h3>Calls:</h3>
<%
    List<Call> list = (ArrayList<Call>) request.getSession().getAttribute("callList");
    if(list.size()<=0){%>
<p>No call orders yet</p>
<%
}
else {
    for(int i = 0; i< list.size(); i++) {%>
<%= list.get(i) %> <a href="<%=request.getContextPath()%>/admin/show-customer?id=<%= list.get(i).getCustomerId() %>">Show</a>
<form name="deleteCallOrder" method="post" action="call-order-list">
    <input type="hidden" name="callIdToDelete" value="<%= list.get(i).getId() %>"/>
    <input type="submit" value="Done" />
</form>
<br>
<% }}%>
</body>
</html>

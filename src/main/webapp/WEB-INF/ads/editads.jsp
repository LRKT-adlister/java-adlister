<%--
  Created by IntelliJ IDEA.
  User: ramonipepperoni
  Date: 7/29/20
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit your Ad" />
    </jsp:include>
</head>
<body><jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <div class="col-md-6 justify-content-center">
        <%--     ADDING FORM RIGHT MEOW   --%>
        <h1>TODO edit Ads.</h1>
        <h1> Title: ${singleAd.title} </h1>
        <h3> Description: ${singleAd.description}</h3>
        <h3>Categories would go here: </h3>
    </div>
</div>


</body>
</html>

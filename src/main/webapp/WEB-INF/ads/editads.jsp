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
    <div class="col-md-6 justify-content-center form-group">
        <h1>TODO edit Ads.</h1>
        <form action="ads/edit" method="get">
            <label for="title"> Title:</label>
            <input id="title" type="text" value="${existingTitle}">
            <label for="description"> Description: </label>
            <input id="description" type="text" value="${existingDescription}">
            <h3>Categories would go here: </h3>

            <button>Save Changes</button>
        </form>
    </div>
</div>


</body>
</html>

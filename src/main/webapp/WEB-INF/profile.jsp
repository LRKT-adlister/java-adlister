<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">

        <h1>Welcome, ${sessionScope.user.username}!</h1>
                <button window.location.replace="http://localhost:8080/ads/create">
                    <a href="/ads/create">Create an Ad</a>
                </button>
    </div>

</body>
</html>

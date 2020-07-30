<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
<<<<<<< HEAD
        <h1>Welcome to the Adlister!</h1>

=======
        <h1>Welcome to LRKT Lister!</h1>
>>>>>>> 7b88a7ef29901f3d47301f27c06439127b491522
    </div>
        <c:forEach var="categories" items="${categories}">
    <div class="col-md-6">
            <p>${categories.title}</p>

    </div>
        </c:forEach>
</body>
</html>

<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ramonipepperoni
  Date: 7/28/20
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${ad.title}</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Single Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<c:forEach >

</c:forEach>

<h1>Test for Single Ads page</h1>
</body>
</html>

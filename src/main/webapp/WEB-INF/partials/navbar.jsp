<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <%--LOGO directing to home/landing page--%>
            <a class="navbar-brand" style="font-family: fantasy" href="/home">LRKT</a>
        </div>


<%--        add a droplist w/ catgegories--%>
<%--        add a search bar for searching through ads--%>
<%--        CREATE A SEARCH SERVLET to help seperate functionality--%>

            <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <%--        IF USER (view) profile & logout--%>
                <c:if test="${sessionScope.user != null}">
                <li><a href="/profile">Profile</a></li>
                <li><a href="/logout">Logout</a></li>
                </c:if>
                <c:otherwise>
                    <%--        VISITOR login & register links--%>
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>

                </c:otherwise>



            </ul>
        </c:choose>




    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

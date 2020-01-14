<%--
  Created by IntelliJ IDEA.
  User: Fabian Corpuz
  Date: 1/11/2020
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- + this taglib is to do the for each loop--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>Home Screen</title>
</head>

<body>

<br>
The following people are allowed access:
<br>
<!-- \/ \/ \/ \/ \/ \/ To print out the list in html \/ \/ \/ \/ \/ \/ \/ \/  -->

<c:if test="${not empty list}">

    <ul>
        <c:forEach var="listValue" items="${list}">
            <li>${listValue}</li>
        </c:forEach>
    </ul>

</c:if>
<br>
you added ${message}
<br>
<form action="addUser" method="get">
    <label>
        <input type="text" name="username" placeholder="Enter Username for new user"> <br>
        <input type="text" name="password" placeholder="Enter password for new user"> <br>
        <input type="submit">
    </label>
</form>

<!-- /\ /\ /\ /\ /\ /\  To print out the list in html /\ /\ /\ /\ /\ /\ /\ /\  -->

</body>

</html>
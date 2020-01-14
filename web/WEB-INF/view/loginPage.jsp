<%--
  Created by IntelliJ IDEA.
  User: Fabian Corpuz
  Date: 1/11/2020
  Time: 11:21 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<!-- this link is using the spring config reference and mapping. See config file  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/login.css" type="text/css" />


<head>
    <title>Login Page</title>
</head>

<body style="background-color: beige">
    <div>

        <div id="floatingScreen">
            <form action="authentication" method="get">

                <div id="loginUsernameField">

                    <label>
                        <input type="text" name="username" placeholder="Enter username">
                    </label>


                </div>

                <div id="logingPasswordField">

                    <label>
                        <input type="text" name="password" placeholder="Enter password">
                    </label>

                </div>
                <input type="submit">
            </form>


        </div>

    </div>
</body>

</html>

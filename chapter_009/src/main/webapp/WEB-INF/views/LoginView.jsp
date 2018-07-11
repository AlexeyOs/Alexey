<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bootstrap Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var result = true;
            var login = document.getElementsByName("login")[0].value;
            var password = document.getElementsByName("password")[0].value;
            if (login == '' || password == '') {
                result = false;
            }
            if (!result) {
                alert("Вы не указали логин или пароль")
            }
            return result;
        }
    </script>
    <style>
    body{
        background-color: #8db4fc; /* Цвет фона веб-страницы */
    }
    .container-fluid{
        text-align: center;
    }
    input{
        color: black;
    }
    </style>
</head>
<body>
<c:if test="${error != ''}">
    <div style="background-color: red">
        <c:out value="${error}"/>
    </div>
</c:if>
<br>
<div class="container-fluid">
<form action="${pageContext.servletContext.contextPath}/signin" method="post" onsubmit="return validate();">
    Login : <input type="text" name="login"><br>
    Password : <input type="password" name="password"><br>
    <input type="submit">
</form>
</div>
</body>
</html>

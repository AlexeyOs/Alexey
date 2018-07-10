<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <style>
    body{
        background-color: #8db4fc; /* Цвет фона веб-страницы */
    }
    .center{
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
<div class="center">
<form action="${pageContext.servletContext.contextPath}/signin" method="post">
    Login : <input type="text" name="login"><br>
    Password : <input type="password" name="password"><br>
    <input type="submit">
</form>
</div>
</body>
</html>

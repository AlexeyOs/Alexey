<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: #8db4fc; /* Цвет фона веб-страницы */
        }
        .center{
            text-align: center;
        }
    </style>
</head>
<body>
<br>
<div class="center">
<form action="${pageContext.servletContext.contextPath}/edit" method='post'>
    Name : <input type='text' name='name' value="${user.name}"/>
    <br>
    Login : <input type='text' name='login' value="${user.login}"/>
    <br>
    Email : <input type='text' name='email' value="${user.email}"/>
    <br>
    Password : <input type='text' name='password' value="${user.password}"/>
    <br>
    CreateDate : <input type='text' name='createDate' value="${user.createDate}"/>
    <br>
    <input type='submit'>
</form>
    <c:if test="${admin.role == 1}">
        <a href="${pageContext.servletContext.contextPath}/list"><input type='submit' value='Все пользователи'></a>
    </c:if>
</div>
</body>
</html>

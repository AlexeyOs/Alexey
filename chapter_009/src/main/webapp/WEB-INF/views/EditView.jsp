<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bootstrap Edit User</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<br>
<div class="container-fluid">
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
    Country : <input type='text' name="country" value="${user.country}"/>
    <br>
    City : <select name="city" value="user.city">
    <option><c:out value="Krasnodar">Krasnodar</c:out></option>
    <option><c:out value="Moscow">Moscow</c:out></option>
    <option><c:out value="Saint Petersburg">Saint Petersburg</c:out></option>
    </select>
    <br>
    <input type='submit'>
</form>
    <c:if test="${admin.role == 1}">
        <a href="${pageContext.servletContext.contextPath}/list"><input type='submit' value='Все пользователи'></a>
    </c:if>
</div>
</body>
</html>

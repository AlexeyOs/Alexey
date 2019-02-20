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
        table{
            text-align: center;
            margin: auto; /* Выравниваем таблицу по центру окна  */
        }
        form{
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<br>
<div class="container-fluid">
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>login</th>
        <th>email</th>
        <th>createDate</th>
    </tr>

    <c:forEach items="${usersParam}" var="user">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.createDate}"></c:out></td>
            <td><form action="${pageContext.servletContext.contextPath}/list?${user.id}" method='post'><input type='submit' value='Удалить пользователя'></form></td>
            <td><a href="${pageContext.servletContext.contextPath}/edit?${user.id}"><input type='submit' value='Редактировать пользователя'></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="${pageContext.servletContext.contextPath}/create" ><input type='submit' value='Создать пользователя'></a></td>
    </tr>
    <tr>
        <td><a href="${pageContext.servletContext.contextPath}/listrole" ><input type='submit' value='Показать роли'></a></td>
    </tr>
</table>
</div>
</body>
</html>

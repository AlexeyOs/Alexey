<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bootstrap List Role</title>
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
            <th>description</th>
            <th>addcontent</th>
            <th>pdatecontent</th>
            <th>seealluser</th>
        </tr>

        <c:forEach items="${roles}" var="role">
            <tr>
                <td><c:out value="${role.id}"></c:out></td>
                <td><c:out value="${role.name}"></c:out></td>
                <td><c:out value="${role.description}"></c:out></td>
                <td><c:out value="${role.addcontent}"></c:out></td>
                <td><c:out value="${role.updatecontent}"></c:out></td>
                <td><c:out value="${role.seealluser}"></c:out></td>
                <td><form action="${pageContext.servletContext.contextPath}/listrole?${role.id}" method='post'><input type='submit' value='Удалить роль'></form></td>
                <td><a href="${pageContext.servletContext.contextPath}/editrole?${role.id}"><input type='submit' value='Редактировать роль'></a></td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="${pageContext.servletContext.contextPath}/createrole" ><input type='submit' value='Создать роль'></a></td>
        </tr>
    </table>
</div>
</body>
</html>

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
<div class="center">
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

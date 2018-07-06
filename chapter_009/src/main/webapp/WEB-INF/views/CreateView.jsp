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
<form action="${pageContext.servletContext.contextPath}/create" method='post'>
    Name : <input type='text' name="name"/>
    <br>
    Login : <input type='text' name="login"/>
    <br>
    Email : <input type='text' name="email"/>
    <br>
    Password : <input type='text' name="password"/>
    <br>
    Role : <select name = "role">
    <option><c:out value="1">1</c:out></option>
    <option><c:out value="2">2</c:out></option>
    </select>
    <br>
    CreateDate : <input type='text' name="createDate"/>
    <input type='submit'>
</form>
</div>
</body>
</html>

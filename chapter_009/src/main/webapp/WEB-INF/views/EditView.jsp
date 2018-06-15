<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
    <input type='submit'>
</form>
<br>
</body>
</html>

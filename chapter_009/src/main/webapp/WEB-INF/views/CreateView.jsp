<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/create" method='post'>
    Name : <input type='text' name="name"/>
    <br>
    Login : <input type='text' name="login"/>
    <br>
    Email : <input type='text' name="email"/>
    <br>
    Password : <input type='text' name="password"/>
    <br>
    CreateDate : <input type='text' name="createDate"/>
    <input type='submit'>
</form>
</body>
</html>

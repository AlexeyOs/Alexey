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
    <form action="${pageContext.servletContext.contextPath}/editrole" method='post'>
        Name : <input type='text' name='name' value="${role.name}"/>
        <br>
        Description : <input type='text' name='description' value="${role.description}"/>
        <br>
        Addcontent : <input type='text' name='addcontent' value="${role.addcontent}"/>
        <br>
        Updatecontent : <input type='text' name='updatecontent' value="${role.updatecontent}"/>
        <br>
        Seealluser : <input type='text' name='seealluser' value="${role.seealluser}"/>
        <br>
        <input type='submit'>
    </form>
</div>
</body>
</html>

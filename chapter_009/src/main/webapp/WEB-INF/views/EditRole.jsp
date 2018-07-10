<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bootstrap Edit Role</title>
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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
<div class="container-fluid">
    <form action="${pageContext.servletContext.contextPath}/edit" method='post'>
        Desc : <input type='text' name='desc' value="${item.desc}"/>
        <br>
        Created : <input type='text' name='created' value="${item.created}"/>
        <br>
        Email : <input type='text' name='email' value="${item.email}"/>
        <br>
        Done : <input type='text' name='done' value="${item.done}"/>
        <br>
        <input type='submit'>
    </form>
</div>
</body>
</html>

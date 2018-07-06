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
    <form action="${pageContext.servletContext.contextPath}/createrole" method='post'>
        Name : <input type='text' name="name"/>
        <br>
        Description : <input type='text' name="description"/>
        <br>
        Addcontent : <input type='text' name="addcontent"/>
        <br>
        Updatecontent : <input type='text' name="updatecontent"/>
        <br>
        Seealluser : <input type='text' name="seealluser"/>
        <input type='submit'>
    </form>
</div>
</body>
</html>

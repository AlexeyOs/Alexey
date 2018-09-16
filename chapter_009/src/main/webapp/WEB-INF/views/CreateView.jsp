<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bootstrap Create User</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var result = true;
            var login = document.getElementsByName("login")[0].value;
            var email = document.getElementsByName("email")[0].value;
            var password = document.getElementsByName("password")[0].value;
            if (!login || !email || !password) {
                result = false;
            }
            if (!result) {
                alert("Укажите email, логин и пароль")
            }
            return result;
        }
    </script>
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
<form action="${pageContext.servletContext.contextPath}/create" method='post' onsubmit="return validate();">
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
    <br>
    Country : <input type='text' name="country"/>
    <br>
    City : <select name="city">
    <option><c:out value="Krasnodar">Krasnodar</c:out></option>
    <option><c:out value="Moscow">Moscow</c:out></option>
    <option><c:out value="Saint Petersburg">Saint Petersburg</c:out></option>
    </select>
    <br>
    <input type='submit'>
</form>
</div>
</body>
</html>

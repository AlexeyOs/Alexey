<%@ page import="osetsky.jsp.UserStorage" %>
<%@ page import="osetsky.jsp.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/echo" method="post">
    Name : <input type="text" name="name"><br>
    Login : <input type="text" name="login"><br>
    Email : <input type="text" name="email"><br>
    CreateDate : <input type="text" name="createDate"><br>
    <input type="submit">
</form>
<br/>
<table style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>name</th>
        <th>login</th>
        <th>email</th>
        <th>createDate</th>
    </tr>
    <% for (User user : UserStorage.getInstance().getUsers()) {%>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getCreateDate()%></td>
    </tr>
    <% } %>
</table>

</body>
</html>

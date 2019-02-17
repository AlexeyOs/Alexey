<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        document.onreadystatechange = function(){
            if(document.readyState === 'complete') {
                selectAllAjax();
            }
        };
        function selectAllAjax() {
            var taskObj = {
                "description": $('#dsc').val(),
                "created": $('#crd').val(),
                "done": $('#don').val()
            };
            var taskJson = JSON.stringify(taskObj);
            var url = "http://localhost:8082/carAll";

            $.ajax({
                type: "POST",
                url: url,
                data: taskJson,
                async: false,
                success: [function (data) {
                    // $('#table').find('tr:last').after(data);
                }],
                error: [function (request) {
                    alert(request.responseText);
                }]
            });
        }
    // function taskReady(text) {
    //
    //     if (false !== document.getElementById(text).checked)
    //     {
    //         document.getElementById(text).checked = true;
    //         alert(true);
    //         alert(text);
    //     } else {
    //         document.getElementById(text).checked = false;
    //         alert(false);
    //     }
    // }
    // function redirect(){
    //     document.location = 'http://localhost:8082/carAdd';
    // }
    </script>
    <%--<style>--%>
        <%--form{--%>
            <%--margin: 2%;--%>
        <%--}--%>
    <%--</style>--%>
</head>
<body>
<div class="table-responsive">
    <table class="table" id ="table">
        <thead>
        <tr>
            <%--<th>Id</th>--%>
            <%--<th>Image</th>--%>
            <th>Brand</th>
            <th>Model</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <%--<td><img src="data:image/jpg;base64,${car.base64Image}" width="240" height="300"/></td>--%>
        <%--<c:forEach var="car" items="${cars}">--%>
        <tr>
            <%--<td><c:out value="${car.id}"></c:out></td>--%>
            <%--<td><c:out value="${car.base64}"/></td>--%>
            <td><c:out value="${car.brand}"/></td>
            <td><c:out value="${car.model}"/></td>
            <td><c:out value="${car.price}"/></td>
        </tr>
        <%--</c:forEach>--%>
        </tbody>
    </table>
</div>
</body>
</html>
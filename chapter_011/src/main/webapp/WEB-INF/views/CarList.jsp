<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
                type: "GET",
                url: url,
                data: taskJson,
                async: false,
                success: [function (data) {

                }],
                error: [function (request) {
                    // alert(request.responseText);
                }]
            });
        }
    function redirect(){
        document.location = 'http://localhost:8082/carAdd';
    }
    </script>
</head>
<body>
<br>
<button type="button" class="btn btn-default" onclick="redirect();">Add car</button>
<br>
<div class="table-responsive">
    <table class="table" id ="table">
        <thead>
        <tr>
            <th>Image</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Price</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.cars}" var="car">
        <tr>
            <td><img src="data:image/jpg;base64,${car.base64Image}" width="240" height="300"/></td>
            <td><c:out value="${car.brand}"/></td>
            <td><c:out value="${car.model}"/></td>
            <td><c:out value="${car.price}"/></td>
            <td><input type="checkbox" checked='<c:out value="${car.status}"/>' onchange="" title="Sale status"/></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
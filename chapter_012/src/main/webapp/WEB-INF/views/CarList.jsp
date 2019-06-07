<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
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
            var url = "/carAll";

            $.ajax({
                type: "GET",
                url: url
            });
        }
    function redirect(){
        document.location = '/carAdd';
    }
    function selectByBrandAjax() {
        document.location = '/lastday';

        var url = "/lastday";

        $.ajax({
            type: "GET",
            url: url,
            headers: {
                'brand': $('#brnd').val()
            }
        });
    }
    function selectByImgAjax() {
        document.location = '/checkImage';

        var url = "/checkImage";

        $.ajax({
            type: "GET",
            url: url,
            headers: {
                'image': $('#img').val()
            }
        });
    }
    </script>
</head>
<body>
<br>
<div class="btn">
    <button type="button" onclick="redirect();">Add car</button>
</div>
<br>
<div class="table-responsive">
    <table class="table" id ="table">
        <thead>
        <tr>
            <th>Image : <select name="img" onchange="selectByImgAjax();" id="img">
                    <option><c:out value="Select">All</c:out></option>
                    <option><c:out value="With photo">WithPhoto</c:out></option>
                    <option><c:out value="Without photo">WithoutPhoto</c:out></option>
                </select>
            </th>
            <th>    Brand : <select name="brand" onchange="selectByBrandAjax();" id="brnd">
                <option><c:out value="Select">All</c:out></option>
                <option><c:out value="Avtovaz">Avtovaz</c:out></option>
                <option><c:out value="BMW">BMW</c:out></option>
            </select></th>
            <th>Model</th>
            <th>Price</th>
            <th> Status : <select name="brand" >
                <option><c:out value="true">true</c:out></option>
                <option><c:out value="false">false</c:out></option>
            </select></th>
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
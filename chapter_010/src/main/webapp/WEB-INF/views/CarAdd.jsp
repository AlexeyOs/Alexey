<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function addCarAjax() {
            var taskObj = {
                "brand": $('#brnd').val(),
                "model": $('#mdl').val(),
                "price": $('#prc').val(),
                "image": $('#img').val()
            };
            var taskJson = JSON.stringify(taskObj);
            var url = "http://localhost:8082/carAdd";
            $.ajax({
                type: "POST",
                url: url,
                data: taskJson,
                async: false,
                success: [function (data) {
                    $('#table').find('tr:last').after(data);
                }],
                error: [function (request) {
                    alert(request.responseText);
                }]
            });
        }
        function redirect(){
            document.location = 'http://localhost:8082/carAdd';
        }
    </script>
</head>
<body>
<form>
    <div class="form-group">
        <label for="brnd">Brand:</label>
        <input type="text" class="form-control" title="Enter description task." id="brnd">
    </div>
    <div class="form-group">
        <label for="mdl">Model:</label>
        <input type="text" class="form-control" id="mdl">
    </div>
    <div class="form-group">
        <label for="prc">Price:</label>
        <input type="text" class="form-control" id="prc">
    </div>
    <form method="post" action="uploadFile" enctype="multipart/form-data">
        Select file to upload:
        <input type="file" name="uploadFile" id="img" />
        <br/><br/>
        <%--<input type="submit" value="Upload" id="img"/>--%>
    </form>
    <br>
    <button type="button" class="btn btn-default" onclick="addCarAjax();">Done</button>
</form>
</body>
</html>

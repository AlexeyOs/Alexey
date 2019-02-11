<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>File Upload Demo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function addCarAjax() {
            var data;
            data = new FormData();
            data.append('file', $('#file')[0].files[0]);

            var url = "http://localhost:8082/carAdd";
            $.ajax({
                type: "POST",
                url: url,
                data: data,
                headers: {
                    'brand':$('#brnd').val(),
                    'model':$('#mdl').val(),
                    'price':$('#prc').val()
                },
                processData: false,
                contentType: false,
                enctype:"multipart/form-data",
                success: [function (data) {
                    $('#table').find('tr:last').after(data);
                }],
                error: [function (request) {
                    alert(request.responseText);
                }]
            });
        }
    </script>
</head>
<body>
    <%--<form method="post" action="carAdd" enctype="multipart/form-data">--%>
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
        Select file to upload:
        <input type="file" name="uploadFile" id="file"/>
        <br/><br/>
        <input type="submit" value="Upload" onclick="addCarAjax();" />
    <%--</form>--%>
</body>
</html>
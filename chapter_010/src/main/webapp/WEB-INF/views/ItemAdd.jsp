<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<br>
<div class="table-responsive">
    <form>
        <div class="form-group">
            <label for="dsc">Description:</label>
            <input type="text" class="form-control" title="Enter description task." id="dsc">
        </div>
        <div class="form-group">
            <label for="crd">Created:</label>
            <input type="datetime" class="form-control" id="crd">
        </div>
        <div class="form-group">
            <label for="don">Done:</label>
            <input type="text" class="form-control" id="don">
        </div>
            <form method="post" action="uploadFile" enctype="multipart/form-data">
                Select file to upload:
                <input type="file" name="uploadFile" />
                <br/><br/>
                <input type="submit" value="Upload"/>
            </form>
        <br>
        <button type="button" class="btn btn-default" onclick="addRowAjax();">Done</button>
    </form>
</div>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>Create New Book</h1>
<form action="/create-book" method="post">
    <div>
        <label>Title</label>
        <input type="text" name="title"/>
    </div>
    <div>
        <label>Description</label>
        <textarea name="description"></textarea>
    </div>
    <div>
        <input type="submit" value="Create"/>
    </div>
</form>
</body>
</html>

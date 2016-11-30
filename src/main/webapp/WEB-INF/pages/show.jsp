<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="demo.models.Book" %>
<% Book book = (Book)request.getAttribute("book"); %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>Book #1</h1>
<form>
    <div>
        <%= book.getTitle() %>
    </div>
    <div>
        <%= book.getDescription() %>
    </div>
</form>
</body>
</html>

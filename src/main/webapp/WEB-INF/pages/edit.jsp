<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="demo.models.Book" %>
<% Book book = (Book)request.getAttribute("book"); %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>Edit Book</h1>
<form>
    <div>
        <label>Title</label>
        <input type="text" name="title" value="<%= book.getTitle() %>"/>
    </div>
    <div>
        <label>Description</label>
        <textarea name="description"><%= book.getDescription() %></textarea>
    </div>
    <div>
        <input type="submit" value="Update"/>
    </div>
</form>
</body>
</html>

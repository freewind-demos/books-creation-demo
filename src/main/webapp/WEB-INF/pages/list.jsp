<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="demo.models.Book" %>
<%
    List<Book> books = (List<Book>)request.getAttribute("books");
    String username = (String)session.getAttribute("username");
    String message = (String)request.getAttribute("message");
%>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<% if(message!=null) { %>
<div><%= message %></div>
<% } %>

<% if(username!=null) { %>
<div>
    Welcome, <span><%= username %></span>
    <a href="/logout">Logout</a>
</div>
<% } %>

<h1>List All Books</h1>
<table border="1" cellpadding="5">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
    </tr>
    <% for(Book book: books) { %>
    <tr>
        <td><%= book.getId() %></td>
        <td><%= book.getTitle() %></td>
        <td><%= book.getDescription() %></td>
    </tr>
    <% } %>
</table>
<div>
    <h2>Create New Book</h2>
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
</div>
</body>
</html>

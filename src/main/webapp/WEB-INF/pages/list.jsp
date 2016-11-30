<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="demo.models.Book" %>
<% List
<Book> books = (List
    <Book>)request.getAttribute("books"); %>
        <html>
        <head>
            <meta charset="UTF-8"/>
        </head>
        <body>
        <div> messages or tips</div>
        <div>
            Welcome, <span>demo</span>
            <a>Logout</a>
        </div>

        <h1>List All Books</h1>
        <table border="1" cellpadding="5">
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Operations</th>
            </tr>
            <% for(Book book: books) { %>
            <tr>
                <td><%= book.getTitle() %></td>
                <td><%= book.getDescription() %></td>
                <td>
                    <a href="/show-book.html?id=<%=book.getId()%>">Show</a>
                    <a href="/edit-book.html?id=<%=book.getId()%>">Edit</a>
                    <a href="/delete-book?id=<%=book.getId()%>">Delete</a>
                </td>
            </tr>
            <% } %>
        </table>
        <p>
            <a href="/create-book.html">Create New Book</a>
        </p>
        </body>
        </html>

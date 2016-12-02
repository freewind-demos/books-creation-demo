<%@ page contentType="text/html; charset=UTF-8" %>
<% String message = (String)request.getAttribute("message"); %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<% if(message!=null) { %>
<div><%= message %></div>
<% } %>

<h1>My Book System</h1>
<form action="/login" method="post">
    <div>
        <label>Username</label>
        <input type="text" name="username"/>
    </div>
    <div>
        <label>Password</label>
        <input type="password" name="password"/>
    </div>
    <div>
        <input type="submit" value="Login"/>
    </div>
</form>
</body>
</html>

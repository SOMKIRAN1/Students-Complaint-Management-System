<%-- 
    Document   : login
    Created on : Mar 12, 2026, 12:06:21 PM
    Author     : somkiran
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Student Login</title>

<!-- Correct CSS Path -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<!-- Navbar -->
<div class="navbar">
    Student Complaint System
</div>

<!-- Container -->
<div class="container">

<h2>Student Login</h2>

<form action="login" method="post">

<input type="number" name="id" placeholder="Student ID" required>

<input type="email" name="email" placeholder="Email" required>

<input type="password" name="password" placeholder="Password" required>

<input type="submit" value="Login">

</form>

<a href="index.jsp">Back to Home</a>

</div>

</body>
</html>
<%-- 
    Document   : admin_login
    Created on : Mar 16, 2026, 10:52:59 AM
    Author     : somkiran
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<!-- Navbar -->
<div class="navbar">
    Student Complaint System
</div>

<!-- Container -->
<div class="container">

<h2>Admin Login</h2>

<form action="adminLogin" method="post">

<input type="email" name="email" placeholder="Admin Email" required>

<input type="password" name="password" placeholder="Password" required>

<input type="submit" value="Login">

</form>

<a href="index.jsp">Back to Home</a>

</div>

</body>
</html>
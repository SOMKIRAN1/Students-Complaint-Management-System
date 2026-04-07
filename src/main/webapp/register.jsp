<%-- 
    Document   : register
    Created on : Mar 11, 2026, 7:38:29 PM
    Author     : somkiran
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>

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

<h2>Student Registration</h2>

<form action="register" method="post">

<input type="text" name="name" placeholder="Full Name" required>

<input type="email" name="email" placeholder="Email Address" required>

<input type="password" name="password" placeholder="Password" required>

<input type="submit" value="Register">

</form>

<a href="index.jsp">Back to Home</a>

</div>

</body>
</html>
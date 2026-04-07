<%-- 
    Document   : admin_dashboard
    Created on : Mar 16, 2026, 10:38:14 AM
    Author     : somkiran
--%>


<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>

<!-- CSS -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<!-- Navbar -->
<div class="navbar">
    Admin Panel - Student Complaint System
</div>

<!-- Container -->
<div class="container">

<h2>Admin Dashboard</h2>

<div class="dashboard-links">

<a href="viewAllComplaints">View All Complaints</a>

<a href="index.jsp">Logout</a>

</div>

</div>

</body>
</html>
<%-- 
    Document   : student_dashboard
    Created on : Mar 12, 2026, 12:09:19 PM
    Author     : somkiran
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>

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

<h2>Student Dashboard</h2>

<div class="dashboard-links">

<a href="complaint_form.jsp">Report Complaint</a>

<a href="viewComplaints">View My Complaints</a>

<a href="logout">Logout</a>

</div>

</div>

</body>
</html>
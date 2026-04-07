<%-- 
    Document   : complaint_form
    Created on : Mar 12, 2026, 12:15:57 PM
    Author     : somkiran
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Submit Complaint</title>

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

<h2>Submit Complaint</h2>

<form action="submitComplaint" method="post">

<textarea name="complaint_text" placeholder="Write your complaint here..." required></textarea>

<select name="category">
<option value="Academic">Academic</option>
<option value="Hostel">Hostel</option>
<option value="Library">Library</option>
<option value="IT">IT</option>
</select>

<select name="is_anonymous">
<option value="false">Submit as Identified</option>
<option value="true">Submit Anonymously</option>
</select>

<input type="submit" value="Submit Complaint">

</form>

<a href="student_dashboard.jsp">Back to Dashboard</a>

</div>

</body>
</html>
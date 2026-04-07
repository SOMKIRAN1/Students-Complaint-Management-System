<%-- 
    Document   : view_complaints
    Created on : Mar 15, 2026, 11:52:57?PM
    Author     : somkiran
--%>

<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.studentcomplaintsystem.model.Complaint" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Complaints</title>
</head>

<body>

<h2>My Complaints</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Complaint</th>
<th>Category</th>
<th>Status</th>
<th>Priority</th>
</tr>

<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.studentcomplaintsystem.model.Complaint" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Complaints</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<!-- Navbar -->
<div class="navbar">
    Student Complaint System
</div>

<h2 style="text-align:center; margin-top:20px;">My Complaints</h2>

<table>

<tr>
<th>ID</th>
<th>Complaint</th>
<th>Category</th>
<th>Status</th>
<th>Priority</th>
</tr>

<%
List<Complaint> complaints = (List<Complaint>) request.getAttribute("complaints");

if(complaints != null){
    for(Complaint c : complaints){
%>

<tr>

<td><%= c.getId() %></td>
<td><%= c.getComplaintText() %></td>
<td><%= c.getCategory() %></td>

<!-- Status with color -->
<td class="status-<%= c.getStatus().toLowerCase().replace(" ", "") %>">
    <%= c.getStatus() %>
</td>

<!-- Priority with color -->
<td class="priority-<%= c.getPriority().toLowerCase() %>">
    <%= c.getPriority() %>
</td>

</tr>

<%
    }
}
%>

</table>

<div style="text-align:center;">
    <a href="student_dashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>
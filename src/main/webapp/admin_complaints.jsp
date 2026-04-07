<%-- 
    Document   : admin_complaints
    Created on : Mar 21, 2026, 3:17:41?PM
    Author     : somkiran
--%>

<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.studentcomplaintsystem.model.Complaint" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Complaints</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<!-- Navbar -->
<div class="navbar">
    Admin Panel - Student Complaint System
</div>

<h2 style="text-align:center; margin-top:20px;">All Complaints</h2>

<table>

<tr>
<th>ID</th>
<th>Student ID</th>
<th>Complaint</th>
<th>Category</th>
<th>Status</th>
<th>Priority</th>
<th>Update</th>
</tr>

<%
List<Complaint> complaints = (List<Complaint>) request.getAttribute("complaints");

if(complaints != null){
    for(Complaint c : complaints){
%>

<tr>

<form action="updateComplaint" method="post">

<td><%= c.getId() %></td>
<td><%= c.getStudentId() %></td>
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

<!-- Update Section -->
<td>

<select name="status">
<option value="Pending">Pending</option>
<option value="In Progress">In Progress</option>
<option value="Resolved">Resolved</option>
</select>

<select name="priority">
<option value="Low">Low</option>
<option value="Medium">Medium</option>
<option value="High">High</option>
</select>

<input type="hidden" name="id" value="<%= c.getId() %>">

<input type="submit" value="Update">

</td>

</form>

</tr>

<%
    }
}
%>

</table>

<div style="text-align:center;">
    <a href="admin_dashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>
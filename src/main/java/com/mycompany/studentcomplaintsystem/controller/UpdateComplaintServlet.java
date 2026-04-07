/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.controller;

import com.mycompany.studentcomplaintsystem.dao.ComplaintDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/updateComplaint")
public class UpdateComplaintServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        String priority = request.getParameter("priority");

        ComplaintDAO dao = new ComplaintDAO();

        dao.updateComplaint(id, status, priority);

        response.sendRedirect("viewAllComplaints");
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.controller;

import com.mycompany.studentcomplaintsystem.dao.ComplaintDAO;
import com.mycompany.studentcomplaintsystem.model.Complaint;
import com.mycompany.studentcomplaintsystem.model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/submitComplaint")
public class SubmitComplaintServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int studentId = user.getId();

        String complaintText = request.getParameter("complaint_text");
        String category = request.getParameter("category");
        boolean anonymous = Boolean.parseBoolean(request.getParameter("is_anonymous"));

        Complaint complaint = new Complaint(studentId, complaintText, category, anonymous);

        ComplaintDAO dao = new ComplaintDAO();

        if(dao.submitComplaint(complaint)){
            response.getWriter().println("Complaint Submitted Successfully");
        }else{
            response.getWriter().println("Error submitting complaint");
        }
    }
}
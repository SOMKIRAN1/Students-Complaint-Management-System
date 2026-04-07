/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.controller;

import com.mycompany.studentcomplaintsystem.dao.ComplaintDAO;
import com.mycompany.studentcomplaintsystem.model.Complaint;
import com.mycompany.studentcomplaintsystem.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author somkiran
 */
@WebServlet("/viewComplaints")
public class ViewComplaintsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

int studentId = (int) session.getAttribute("student_id");

ComplaintDAO dao = new ComplaintDAO();

List<Complaint> complaints = dao.getComplaintsByStudent(studentId);

request.setAttribute("complaints", complaints);

request.getRequestDispatcher("view_complaints.jsp").forward(request, response);
    }
}
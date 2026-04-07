/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.controller;

import com.mycompany.studentcomplaintsystem.dao.ComplaintDAO;
import com.mycompany.studentcomplaintsystem.model.Complaint;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/viewAllComplaints")
public class ViewAllComplaintsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ComplaintDAO dao = new ComplaintDAO();

        List<Complaint> complaints = dao.getAllComplaints();

        request.setAttribute("complaints", complaints);

        request.getRequestDispatcher("admin_complaints.jsp").forward(request, response);
    }
}
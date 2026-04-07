/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.controller;

import com.mycompany.studentcomplaintsystem.dao.UserDAO;
import com.mycompany.studentcomplaintsystem.model.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    UserDAO dao = new UserDAO();

    User admin = dao.adminLogin(email, password);

    if(admin != null && admin.getRole().equals("admin")){

        HttpSession session = request.getSession();
        session.setAttribute("admin", admin);

        response.sendRedirect("admin_dashboard.jsp");

    }else{

        response.getWriter().println("Invalid Admin Credentials");

    }
}
}


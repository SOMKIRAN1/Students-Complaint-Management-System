/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.controller;

import com.mycompany.studentcomplaintsystem.dao.UserDAO;
import com.mycompany.studentcomplaintsystem.model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    UserDAO dao = new UserDAO();

    User user = dao.loginUser(id, email, password);

    if(user != null){

        HttpSession session = request.getSession();

        session.setAttribute("user", user);
        session.setAttribute("student_id", id);

        if(user.getRole().equals("admin")){
            response.sendRedirect("admin_dashboard.jsp");
        }else{
            response.sendRedirect("student_dashboard.jsp");
        }

    }else{

        response.getWriter().println("Invalid credentials");

    }
}
}
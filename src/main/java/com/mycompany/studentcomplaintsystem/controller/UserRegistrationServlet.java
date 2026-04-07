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

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Debug log
        System.out.println(name + " " + email + " " + password);

        // id = 0 because database auto-generates it
        User user = new User(0, name, email, password, "student");

        UserDAO dao = new UserDAO();
        boolean status = dao.registerUser(user);

        response.setContentType("text/html");

        if (status) {
            response.getWriter().println("<h2>Registration Successful</h2>");
            response.getWriter().println("<br><a href='login.jsp'>Go to Login</a>");
        } else {
            response.getWriter().println("<h2>Error occurred while saving user</h2>");
        }
    }
}
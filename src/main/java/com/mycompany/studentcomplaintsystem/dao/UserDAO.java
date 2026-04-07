/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.dao;

import com.mycompany.studentcomplaintsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDAO {
    

    public boolean registerUser(User user) {

        boolean status = false;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            ps.executeUpdate();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public User loginUser(int id, String email, String password){

    User user = null;

    try{

        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM users WHERE id=? AND email=? AND password=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, email);
        ps.setString(3, password);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role")
            );
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return user;
}

    public User adminLogin(String email, String password){

    User user = null;

    try{

        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM users WHERE email=? AND password=? AND role='admin'";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role")
            );
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return user;
}
}
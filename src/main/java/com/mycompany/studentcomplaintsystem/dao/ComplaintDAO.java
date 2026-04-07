/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.dao;

import com.mycompany.studentcomplaintsystem.model.Complaint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {

    public boolean submitComplaint(Complaint complaint){

        boolean status = false;

        try{

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO complaints(student_id, complaint_text, category, sentiment, priority, status, is_anonymous) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, complaint.getStudentId());
            ps.setString(2, complaint.getComplaintText());
            ps.setString(3, complaint.getCategory());

            // default values for now
            ps.setString(4, "neutral");
            ps.setString(5, "medium");
            ps.setString(6, "Pending");

            ps.setBoolean(7, complaint.isAnonymous());

            ps.executeUpdate();

            status = true;

        }catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }
    public List<Complaint> getComplaintsByStudent(int studentId){

    List<Complaint> list = new ArrayList<>();

    try{

        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM complaints WHERE student_id=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, studentId);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            Complaint c = new Complaint(
                rs.getInt("student_id"),
                rs.getString("complaint_text"),
                rs.getString("category"),
                rs.getBoolean("is_anonymous")
            );
            
            c.setId(rs.getInt("id"));
            c.setStatus(rs.getString("status"));
            c.setPriority(rs.getString("priority"));

            list.add(c);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return list;
}
    
    public List<Complaint> getAllComplaints(){

    List<Complaint> list = new ArrayList<>();

    try{

        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM complaints";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            Complaint c = new Complaint(
                rs.getInt("student_id"),
                rs.getString("complaint_text"),
                rs.getString("category"),
                rs.getBoolean("is_anonymous")
            );

            c.setId(rs.getInt("id"));
            c.setStatus(rs.getString("status"));
            c.setPriority(rs.getString("priority"));

            list.add(c);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return list;
}
    public boolean updateComplaint(int id, String status, String priority){

    boolean result = false;

    try{

        Connection conn = DBConnection.getConnection();

        String sql = "UPDATE complaints SET status=?, priority=? WHERE id=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, status);
        ps.setString(2, priority);
        ps.setInt(3, id);

        ps.executeUpdate();

        result = true;

    }catch(Exception e){
        e.printStackTrace();
    }

    return result;
}
}
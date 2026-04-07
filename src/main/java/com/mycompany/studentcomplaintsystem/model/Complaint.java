/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentcomplaintsystem.model;

public class Complaint {

    private int studentId;
    private String complaintText;
    private String category;
    private boolean anonymous;
    private int id;
    private String status;
    private String priority;
    public int getId(){ return id; }
    public String getStatus(){ return status; }
    public String getPriority(){ return priority; }

    public Complaint(int studentId, String complaintText, String category, boolean anonymous) {
        this.studentId = studentId;
        this.complaintText = complaintText;
        this.category = category;
        this.anonymous = anonymous;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setId(int id){
    this.id = id;
    }

    public void setStatus(String status){
    this.status = status;
    }

    public void setPriority(String priority){
    this.priority = priority;
    }
}
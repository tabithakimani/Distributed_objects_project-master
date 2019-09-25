package com.ics.demo.models;

public class Attachment {
    private int studentId;
    private int companyId;
    private String name;

    public Attachment(int studentId, int companyId, String name) {
        this.studentId = studentId;
        this.companyId = companyId;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public  int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.a20f0196.firebaseactivity;

public class Student {
    private String name;
    private String dept;
    private String regNo;
    private float cgpa;
    private String email;

    public Student() {
        // Default constructor required for calls to DataSnapshot.getValue(Student.class)
    }

    public Student(String name, String dept, String regNo, float cgpa, String email) {
        this.name = name;
        this.dept = dept;
        this.regNo = regNo;
        this.cgpa = cgpa;
        this.email = email;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getRegNo() {
        return regNo;
    }

    public float getCgpa() {
        return cgpa;
    }

    public String getEmail() {
        return email;
    }
}

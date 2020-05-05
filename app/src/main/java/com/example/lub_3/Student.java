package com.example.lub_3;

public class Student {
    int id;
    String[] subStr;
    String name;
    String Lname;
    String Oname;
    String date;

    public Student(){}
    public Student(String ada, String date){
        subStr = ada.split("\\s");
        this.Lname = subStr[0];
        this.name = subStr[1];
        this.Oname = subStr[2];
        this.date = date;
    }
    public Student(int id, String ada, String date){
        this.id = id;
        subStr = ada.split("\\s");
        this.Lname = subStr[0];
        this.name = subStr[1];
        this.name = subStr[2];
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLName() {
        return Lname;
    }
    public String getOName() {
        return Oname;
    }
    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLName(String Lname) {
        this.Lname = Lname;
    }
    public void setOName(String Oname) {
        this.Oname = Oname;
    }
}

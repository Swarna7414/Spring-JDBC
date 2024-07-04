package com.demo.Model;

import lombok.*;

@Data
public class StudentModel {
    public StudentModel() {
    }
    public StudentModel(int id, String name, int roll, int age, int marks) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.age = age;
        this.marks = marks;
    }

    private int id;
    private String name;
    private int roll;
    private int age;
    private int marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

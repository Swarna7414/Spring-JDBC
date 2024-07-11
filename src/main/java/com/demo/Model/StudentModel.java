package com.demo.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("students")
public class StudentModel {


    @Id
    private int id;
    private String name;
    private String std;
    private String marks;

    public StudentModel() {
    }

    public StudentModel(int id, String name, String std, String marks) {
        this.id = id;
        this.name = name;
        this.std = std;
        this.marks = marks;
    }

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

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}

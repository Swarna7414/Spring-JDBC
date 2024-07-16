package com.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class StudentModel {
    @Id
    private int roll;

    private int age;

    private List<String> electives;

    public StudentModel() {
    }

    public StudentModel(int roll, int age, List<String> electives) {
        this.roll = roll;
        this.age=age;
        this.electives = electives;
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


    public List<String> getElectives() {
        return electives;
    }

    public void setElectives(List<String> electives) {
        this.electives = electives;
    }
}

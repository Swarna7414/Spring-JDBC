package com.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;


public class Student {
    @Id
    private Integer roll;

    private String name;

    private Integer age;

    private List<String> electives;

    private Map<String, Integer> marks;

    private Float percentage;

    public Student() {
    }

    public Student(Integer roll, String name, Integer age, List<String> electives, Map<String, Integer> marks,Float percentage) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.electives = electives;
        this.marks = marks;
        this.percentage = percentage;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getElectives() {
        return electives;
    }

    public void setElectives(List<String> electives) {
        this.electives = electives;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }


}

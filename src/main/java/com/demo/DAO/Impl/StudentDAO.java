package com.demo.DAO.Impl;

import com.demo.Model.Student;

import java.util.List;

public interface StudentDAO {

    public void Createdetails(Student student);

    public Student getone(int roll);

    public List<Student> getall();

    public String updatedone(Student student);

    public String delete(int roll);
}

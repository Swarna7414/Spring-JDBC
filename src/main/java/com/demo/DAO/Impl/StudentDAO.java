package com.demo.DAO.Impl;

import com.demo.Model.StudentModel;

import java.util.List;

public interface StudentDAO {
    public void save(StudentModel studentModel);

    public List<StudentModel> getall();

    public StudentModel findbyid(int roll);

    public String updatebyid(StudentModel studentModel);

    public String deletebyid(int roll);
}

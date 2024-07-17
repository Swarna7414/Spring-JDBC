package com.demo.DAO.Impl;

import com.demo.Model.StudentModel;

import java.util.List;

public interface StudentDAO {
    public void save(StudentModel studentModel);

    public List<StudentModel> getall();

    public StudentModel findbyid(int roll);
}

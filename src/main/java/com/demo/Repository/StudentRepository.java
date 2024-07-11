package com.demo.Repository;

import com.demo.Model.StudentModel;

import java.util.List;

public interface StudentRepository {
    public String createstudent(StudentModel model);

    public List<StudentModel> getallstudents();

    public StudentModel getstudent(int id);

}

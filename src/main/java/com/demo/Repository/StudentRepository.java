package com.demo.Repository;

import com.demo.Model.StudentModel;

import java.util.List;

public interface StudentRepository {
    public void createupser(StudentModel stdent);

    public List<StudentModel> getusers();

    public StudentModel getUserById(int id);
}

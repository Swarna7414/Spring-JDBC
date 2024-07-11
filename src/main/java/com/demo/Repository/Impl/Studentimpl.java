package com.demo.Repository.Impl;

import com.demo.Model.StudentModel;
import com.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Studentimpl implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String createstudent(StudentModel model) {
        String quary="INSERT INTO Student.students(id,name,std,marks) VALUES (?,?,?,?)";
        jdbcTemplate.update(quary,model.getId(),model.getName(),model.getStd(),model.getMarks());
        return "Student created successflly";
    }

    @Override
    public List<StudentModel> getallstudents() {
        String quary="SELECT * FROM Student.students";
        return jdbcTemplate.query(quary,(rs,rownum)->
                new StudentModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("std"),
                        rs.getString("marks")
                )
        );
    }

    @Override
    public StudentModel getstudent(int id) {
        String quary="SELECT * FROM Student.students WHERE id=?";
        return jdbcTemplate.queryForObject(quary, new Object[]{id}, (rs,rowNum)->
                new StudentModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("std"),
                        rs.getString("marks")
                )
        );
    }
}

package com.demo.Repository;

import com.demo.Model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createupser(StudentModel student) {
        String quary= "INSERT INTO student.users(id,name,roll,age,marks) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(quary,student.getId(),student.getName(),student.getRoll(),student.getAge(),student.getMarks());
    }

    @Override
    public List<StudentModel> getusers() {
        String query = "SELECT * FROM Student.users";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            StudentModel model = new StudentModel();
            model.setId(rs.getInt("id"));
            model.setName(rs.getString("name"));
            model.setRoll(rs.getInt("roll"));
            model.setAge(rs.getInt("age"));
            model.setMarks(rs.getInt("marks"));

            return model;
        });
    }

    @Override
    public StudentModel getUserById(int id) {
        String query = "SELECT * FROM student.users WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<StudentModel>() {
            @Override
            public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapResultSetToStudentModel(rs);
            }
        });
    }

    private StudentModel mapResultSetToStudentModel(ResultSet rs) throws SQLException {
        StudentModel model = new StudentModel();
        model.setId(rs.getInt("id"));
        model.setName(rs.getString("name"));
        model.setRoll(rs.getInt("roll"));
        model.setAge(rs.getInt("age"));
        model.setMarks(rs.getInt("marks"));
        return model;
    }
}



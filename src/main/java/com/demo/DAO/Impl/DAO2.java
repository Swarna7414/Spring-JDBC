/*
package com.demo.DAO.Impl;

import com.demo.Model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAO2 implements StudentDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(StudentModel studentModel) {
        String statement="INSERT INTO Student.students(roll,age) VALUES(?,?)";
        jdbcTemplate.update(statement,studentModel.getRoll(),studentModel.getAge());

        for (String i:studentModel.getElectives()){
            String statemente="INSERT INTO Student.electives(roll,elective)Values(?,?)";
            jdbcTemplate.update(statemente,studentModel.getRoll(),i);
        }
    }

    @Override
    public List<StudentModel> getall() {
        String statement="SELECT * FROM Student.students";
        List<StudentModel> students= jdbcTemplate.query(statement,new StudentMapper());

        for (StudentModel i: students){
            String statemente="SELECT * FROM Student.electives WHERE roll=?";
            List<String> ele=jdbcTemplate.query(statemente, new Electivemapper(), i.getRoll());
            i.setElectives(ele);
        }
        return students;
    }

    @Override
    public StudentModel findbyid(int roll) {

        String statement="SELECT * FROM Student.students where roll =?";
        StudentModel studentM=jdbcTemplate.queryForObject(statement,new StudentMapper(),roll);
        String statemente="SELECT * FROM Student.electives where roll=?";
        List<String> electives=jdbcTemplate.query(statemente,new Electivemapper(),roll);
        studentM.setElectives(electives);
        return studentM;
    }

    @Override
    public String updatebyid(StudentModel studentModel) {
        String statement="UPDATE Student.students SET age =? WHERE roll =?";
        jdbcTemplate.update(statement,studentModel.getAge(), studentModel.getRoll());

        String delete="DELETE FROM Student.electives WHERE roll=?";
        jdbcTemplate.update(delete,studentModel.getRoll());

        for(String i: studentModel.getElectives()){
            String statemente="INSERT INTO Student.electives (roll, elective) values(?, ?)";
            jdbcTemplate.update(statemente,studentModel.getRoll(),i);
        }

        return "Updated successfully";
    }

    @Override
    public String deletedetails(int roll) {
        jdbcTemplate.update("DELETE FROM Student.students WHERE roll =?",roll);
        jdbcTemplate.update("DELETE FROM Student.electives WHERE roll =?",roll);
        return "Student details deleted";
    }

    public static final class StudentMapper implements RowMapper<StudentModel>{

        @Override
        public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            StudentModel model= new StudentModel();
            model.setRoll(rs.getInt("roll"));
            model.setAge(rs.getInt("age"));

            return model;
        }
    }

    public static final class Electivemapper implements RowMapper<String>{

        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString("elective");
        }
    }
}
*/

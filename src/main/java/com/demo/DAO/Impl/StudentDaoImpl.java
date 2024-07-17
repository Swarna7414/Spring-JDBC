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
public class StudentDaoImpl implements StudentDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(StudentModel student){
        String SQL="INSERT INTO student.students(roll,age) VALUES (?,?)";
        jdbcTemplate.update(SQL,student.getRoll(),student.getAge());

        for (String elective:student.getElectives()){
            String SQL2="INSERT INTO student.electives(roll, elective) VALUES (?, ?)";
            jdbcTemplate.update(SQL2,student.getRoll(),elective);
        }
    }

    @Override
    public List<StudentModel> getall(){
        String sql="SELECT * FROM student.students";
        List<StudentModel> all=jdbcTemplate.query(sql,studentRowMapper);

        for(StudentModel studentModel: all){
            List<String> electives = jdbcTemplate.query("SELECT elective FROM student.electives WHERE roll = ?", new Object[]{studentModel.getRoll()}, (rs, rowNum) -> rs.getString("elective"));

            studentModel.setElectives(electives);
        }

        return all;
    }

    @Override
    public StudentModel findbyid(int roll) {
        String txt = "SELECT * FROM student.students WHERE roll = ?";
        StudentModel studentModel = jdbcTemplate.queryForObject(txt, new Object[]{roll}, studentRowMapper);

        if (studentModel != null) {
            String txt1 = "SELECT elective FROM student.electives WHERE roll=?";
            List<String> electives = jdbcTemplate.query(txt1, new Object[]{roll}, (rs, rowNum) -> rs.getString("elective"));
            studentModel.setElectives(electives);
        }

        return studentModel;
    }

    @Override
    public String updatebyid(StudentModel studentModel) {
        String sql="UPDATE student.students SET age=? WHERE roll=?";
        jdbcTemplate.update(sql,studentModel.getAge(),studentModel.getRoll());

        String sqldelele="DELETE FROM student.electives WHERE roll=?";
        jdbcTemplate.update(sqldelele,studentModel.getRoll());

        for(String i: studentModel.getElectives()){
            String addsql="INSERT INTO student.electives(roll,elective)VALUES(?,?)";
            jdbcTemplate.update(addsql,studentModel.getRoll(),i);
        }

        return "Student Details updated";
    }

    @Override
    public String deletedetails(int roll) {
        String delete="DELETE FROM student.electives where roll=?";
        jdbcTemplate.update(delete,roll);
        jdbcTemplate.update("DELETE FROM student.students WHERE roll=?",roll);
        return "details deleted"+roll;
    }


    private static final RowMapper<StudentModel> studentRowMapper = new RowMapper<StudentModel>() {
        @Override
        public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            StudentModel student = new StudentModel();
            student.setRoll(rs.getInt("roll"));
            student.setAge(rs.getInt("age"));
            return student;
        }
    };
}

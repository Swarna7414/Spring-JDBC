package com.demo.DAO.Impl.Impl;

import com.demo.DAO.Impl.StudentDAO;
import com.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentImplDAO implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void Createdetails(Student student) {
        int count=student.getMarks().size();
        float totalmarks=0;
        for(Map.Entry<String, Integer> i: student.getMarks().entrySet()){
            totalmarks+=i.getValue();
        }
        float percentage=totalmarks/count;
        student.setPercentage(percentage);

        // we inserted the values in the students table
        String statement = "INSERT INTO Student.students(roll, name, age, percentage) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(statement,student.getRoll(),student.getName(),student.getAge(),student.getPercentage());

        // we inserted the values in Elective(List) table
        for(String i: student.getElectives()){
            String statemente="INSERT INTO Student.electives(roll, elective_name) VALUES(?, ?)";
            jdbcTemplate.update(statemente,student.getRoll(),i);
        }

        //we inserted the values in the HASHMAP(Map) table
        for(Map.Entry<String, Integer> i: student.getMarks().entrySet()){
            String statementm="INSERT INTO Student.marks(roll, subject_name, mark) VALUES(?, ?, ?)";
            jdbcTemplate.update(statementm,student.getRoll(),i.getKey(),i.getValue());
        }
    }

    @Override
    public Student getone(int roll) {
        String sql="SELECT * from student.students where roll=?";
        Student student=jdbcTemplate.queryForObject(sql,new Object[] {roll}, new StudentMapper());
        String statement2="SELECT elective_name FROM Student.electives where roll =?";
        student.setElectives(jdbcTemplate.queryForList(statement2,new Object[]{roll},String.class));

        String statement3="SELECT subject_name, mark FROM student.marks where roll=?";
        Map<String, Integer> marks=jdbcTemplate.query(statement3,new Object[]{roll},rs->{
            Map<String, Integer> marksmap=new HashMap<>();
            while (rs.next()){
                marksmap.put(rs.getString("subject_name"),rs.getInt("mark"));
            }
            return marksmap;
        });

        student.setMarks(marks);

        return student;
    }

    @Override
    public List<Student> getall() {
        String sql="SELECT * FROM student.students";
        List<Student> all=jdbcTemplate.query(sql,new StudentMapper());
        // we are using same for loop for two tables : )
        for(Student student: all){
            int roll=student.getRoll();
            String statemente="select elective_name from student.electives where roll=?";
            List<String> electives=jdbcTemplate.queryForList(statemente,new Object[]{roll},String.class);
            student.setElectives(electives);

            // FOR HASHMAP
            String sql3="SELECT subject_name, mark from student.marks where roll=?";
            Map<String, Integer> maps=jdbcTemplate.query(sql3,new Object[]{roll},rs->{
                Map<String, Integer> mapps= new HashMap<>();
                while (rs.next()){
                    mapps.put(rs.getString("subject_name"),rs.getInt("mark"));
                }
                return mapps;
            });

            student.setMarks(maps);
        }
        return all;
    }

    @Override
    public String updatedone(Student student) {

        int count=student.getMarks().size();
        float totalmarks=0;
        for(Map.Entry<String, Integer> i: student.getMarks().entrySet()){
            totalmarks+=i.getValue();
        }
        float percentage=totalmarks/count;
        student.setPercentage(percentage);

        String statement="update student.students SET name= ?, age=?, percentage=? where roll =?";
        jdbcTemplate.update(statement,student.getName(),student.getAge(),student.getPercentage(),student.getRoll());

        //deleted the Elements present in the table.
        String statementdelete="delete from student.electives where roll=?";
        jdbcTemplate.update(statementdelete,student.getRoll());

        // inserted to the table.
        String insertelect="insert into student.electives(roll,elective_name) values(?,?)";
        for(String i: student.getElectives()){
            jdbcTemplate.update(insertelect,student.getRoll(),i);
        }

        String Deletemap="delete from student.marks where roll=?";
        jdbcTemplate.update(Deletemap,student.getRoll());

        String insertmarks="insert into student.marks(roll,subject_name,mark) values(?,?,?)";
        for (Map.Entry<String, Integer> i: student.getMarks().entrySet()){
            jdbcTemplate.update(insertmarks,student.getRoll(),i.getKey(),i.getValue());
        }

        return "Updated values successfully";
    }

    @Override
    public String delete(int roll) {
        String statementmap="delete from student.marks where roll=?";
        jdbcTemplate.update(statementmap,roll);
        String statemente="delete from student.electives where roll=?";
        jdbcTemplate.update(statemente,roll);
        String Statement="delete from student.students where roll=?";
        jdbcTemplate.update(Statement,roll);

        return "Deleted Values Successfully";
    }

    public static class StudentMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student= new Student();
            student.setRoll(rs.getInt("roll"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setPercentage(rs.getFloat("percentage"));

            return student;
        }
    }
}

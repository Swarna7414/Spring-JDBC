package com.demo.DAO.Impl;

import com.demo.DAO.EmployeeDao;
import com.demo.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAOimpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String CreateEmployee(EmployeeModel employee) {
        String quary = "INSERT INTO Student.employee (id,name,age,salary,experience) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(quary,employee.getId(),employee.getName(),employee.getAge(),employee.getSalary(),employee.getExperience());
        return "EMPLOYEE Created";
    }

    @Override
    public List<EmployeeModel> GetallEmployeeModel() {
        String query = "SELECT * FROM Student.employee";
        return jdbcTemplate.query(query,new EmployeeRowMapper());
    }

/*    @Override   or ELSE WE CAN ALSO WRITE LIKE THIS : ) 
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
    }*/

    @Override
    public EmployeeModel getonebyid(Integer id) {
        String quary= "SELECT * FROM Student.employee WHERE id =?";
        return jdbcTemplate.queryForObject(quary,new Object[]{id},new EmployeeRowMapper());
    }

    @Override
    public List<Map<String, Object>> mapping() {
        String sql="SELECT name, experience from Student.employee";
        return jdbcTemplate.queryForList(sql);
    }

    private static final class EmployeeRowMapper implements RowMapper<EmployeeModel>{

        @Override
        public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmployeeModel employeeModel= new EmployeeModel();
            employeeModel.setId(rs.getInt("id"));
            employeeModel.setName(rs.getString("name"));
            employeeModel.setAge(rs.getInt("age"));
            employeeModel.setExperience(rs.getInt("experience"));
            employeeModel.setSalary(rs.getInt("salary"));

            return employeeModel;
        }
    }
}
/*
package com.demo.DAO.Impl;

import com.demo.DAO.EmployeeDao;
import com.demo.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class chummaDao implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String CreateEmployee(EmployeeModel employee) {
        String statement="INSERT INTO Student.employee(id,name,age,experience,salary) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(statement,employee.getId(),employee.getName(),employee.getAge(),employee.getSalary(),employee.getExperience());
        return "Employee detils created";
    }

    @Override
    public List<EmployeeModel> GetallEmployeeModel() {
        String sql="SELECT * FROM Student.employee";
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }

    @Override
    public EmployeeModel getonebyid(Integer id) {
        // you can also write like this : )
        String statement="SELECT * FROM Student.employee WHERE id=?";
        EmployeeRowMapper employeeRowMapper= new EmployeeRowMapper();
        return jdbcTemplate.queryForObject(statement,new Object[]{id},employeeRowMapper);
    }

    public static final class EmployeeRowMapper implements RowMapper<EmployeeModel>{

        @Override
        public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmployeeModel employeeModel= new EmployeeModel();
            employeeModel.setId(rs.getInt("id"));
            employeeModel.setName(rs.getString("name"));
            employeeModel.setAge(rs.getInt("age"));
            employeeModel.setExperience(rs.getInt("experiece"));
            employeeModel.setSalary(rs.getInt("salary"));

            return employeeModel;
        }
    }
}
*/

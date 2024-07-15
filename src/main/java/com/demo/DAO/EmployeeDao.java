package com.demo.DAO;

import com.demo.Model.EmployeeModel;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    public String CreateEmployee(EmployeeModel employee);

    public List<EmployeeModel> GetallEmployeeModel();

    public EmployeeModel getonebyid(Integer id);

    public List<Map<String, Object>> mapping();

}

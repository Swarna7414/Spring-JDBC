package com.demo.DAO;

import com.demo.Model.EmployeeModel;

import java.util.List;

public interface EmployeeDao {
    public String CreateEmployee(EmployeeModel employee);

    public List<EmployeeModel> GetallEmployeeModel();

    public EmployeeModel getonebyid(Integer id);
}

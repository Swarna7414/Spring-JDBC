package com.demo.Controller;

import com.demo.DAO.EmployeeDao;
import com.demo.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping
    public String Createemployee(@RequestBody EmployeeModel employeeModel){
        return employeeDao.CreateEmployee(employeeModel);
    }

    @GetMapping("/one/{id}")
    public EmployeeModel getonebyid(@PathVariable int id){
        return employeeDao.getonebyid(id);
    }

    @GetMapping
    public List<EmployeeModel> getallbyid(){
        return employeeDao.GetallEmployeeModel();
    }
}

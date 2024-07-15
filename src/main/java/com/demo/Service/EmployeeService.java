package com.demo.Service;

import com.demo.DAO.EmployeeDao;
import com.demo.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeModel getfirstone(){
        List<EmployeeModel> allempmodels = employeeDao.GetallEmployeeModel();
        EmployeeModel employeeModel=allempmodels.stream().max(Comparator.comparingInt(EmployeeModel::getExperience))
                .orElse(null);

        return employeeModel;
    }


    public List<EmployeeModel> sortedbyexperience(){
        List<EmployeeModel> allempmodels = employeeDao.GetallEmployeeModel();
        List<EmployeeModel> sortedones= allempmodels.stream().sorted(Comparator.comparingInt(EmployeeModel::getAge))
                .collect(Collectors.toList());
        return sortedones;
    }
}

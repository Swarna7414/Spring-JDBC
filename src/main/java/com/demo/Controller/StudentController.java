package com.demo.Controller;

import com.demo.DAO.Impl.StudentDAO;
import com.demo.DAO.Impl.StudentDaoImpl;
import com.demo.Model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDAO studentDao;

    @PostMapping
    public void createstudent(@RequestBody StudentModel studentModel){
        studentDao.save(studentModel);
    }

    @GetMapping
    public List<StudentModel> geall(){
        return studentDao.getall();
    }

    @GetMapping("/one/{roll}")
    public StudentModel getone(@PathVariable int roll){
        return studentDao.findbyid(roll);
    }

    @PutMapping
    public String updateone(@RequestBody StudentModel studentModel){
        return studentDao.updatebyid(studentModel);
    }

    @DeleteMapping("delete/{roll}")
    public String deletedetails(@PathVariable int roll){
        return studentDao.deletebyid(roll);
    }

}

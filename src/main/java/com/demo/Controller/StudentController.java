package com.demo.Controller;

import com.demo.DAO.Impl.StudentDAO;
import com.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/student")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @PostMapping("/create")
    public String createdetails(@RequestBody Student student){
        studentDAO.Createdetails(student);
        return "Detils Successfully created";
    }

    @GetMapping("/one/{roll}")
    public Student getone(@PathVariable int roll){
        return studentDAO.getone(roll);
    }

    @GetMapping("/all")
    public List<Student> getall(){
        return studentDAO.getall();
    }
}

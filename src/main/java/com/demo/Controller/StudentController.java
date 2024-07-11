package com.demo.Controller;

import com.demo.Model.StudentModel;
import com.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public String createstudent(@RequestBody StudentModel model){
        return studentRepository.createstudent(model);
    }

    @GetMapping
    public List<StudentModel> getallstudents(){
        return studentRepository.getallstudents();
    }

    @GetMapping("/{id}")
    public StudentModel getonebyid(@PathVariable int id){
        return studentRepository.getstudent(id);
    }
}

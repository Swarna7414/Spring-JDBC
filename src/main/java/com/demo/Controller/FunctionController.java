package com.demo.Controller;

import com.demo.Model.Student;
import com.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    StudentService studentService;

    @GetMapping("/byranked")
    public List<Student> sorted(){
        return studentService.sortedbygrade();
    }

    @GetMapping("/pir")
    public List<String> passedonpirticular(String subject){
        return studentService.passedone(subject);
    }

    @GetMapping("/pir/fail")
    public List<String> failedonpirticular(String subject){
        return studentService.failedone(subject);
    }

    @GetMapping("/maxone")
    public String topper(){
        return studentService.topper();
    }

    @GetMapping("/maxsubject")
    public String pirticular(String subject){
        return studentService.topperinpircticularsubject(subject);
    }

}

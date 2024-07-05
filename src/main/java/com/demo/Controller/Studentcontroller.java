package com.demo.Controller;

import com.demo.Model.StudentModel;
import com.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Studentcontroller {

    @Autowired
    private StudentRepository studentRepository;
    @PostMapping
    public String createuser(@RequestBody StudentModel studentModel){
        studentRepository.createupser(studentModel);
        return "Student Created Sucessfully";
    }

    @GetMapping("/all/users")
    public List<StudentModel> getallusers(){
        return studentRepository.getusers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> getone(@PathVariable int id){
        StudentModel studentModel = studentRepository.getUserById(id);
        if(studentModel!=null){
            return ResponseEntity.ok(studentModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updated")
    public String uppdatestudent(@RequestBody StudentModel studentModel){
        studentRepository.updatestudentmodel(studentModel);
        return "Student details has been updated" + studentModel.getName();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteone(@PathVariable int id){
        studentRepository.deletestudent(id);
        return "Student detals has been deleted";
    }

}

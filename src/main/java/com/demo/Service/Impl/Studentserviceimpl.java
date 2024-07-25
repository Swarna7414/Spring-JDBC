package com.demo.Service.Impl;

import com.demo.DAO.Impl.StudentDAO;
import com.demo.Model.Student;
import com.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Studentserviceimpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;


    @Override
    public List<Student> sortedbygrade() {
        List<Student> all=studentDAO.getall();
        List<Student> sorted=all.stream().sorted(Comparator.comparing(Student::getPercentage).reversed()).collect(Collectors.toList());
        return sorted;
    }

    @Override
    public List<String> passedone(String subject) {
        List<Student> all=studentDAO.getall();
        List<String> passed=all.stream().filter(n->n.getMarks().containsKey(subject) && n.getMarks().get(subject) >= 35)
                .map(Student::getName).collect(Collectors.toList());
        return passed;
    }

    @Override
    public List<String> failedone(String subject) {
        List<Student> all=studentDAO.getall();
        List<String> failed=all.stream().filter(n->n.getMarks().containsKey(subject) && n.getMarks().get(subject) <= 35)
                .map(Student::getName).collect(Collectors.toList());
        return failed;
    }

    @Override
    public String topper() {
        List<Student> all=studentDAO.getall();
        Student model=all.stream().max(Comparator.comparing(Student::getPercentage)).orElse(null);
        return "The topper was"+model.getName()+"with"+model.getPercentage();
    }

    @Override
    public String topperinpircticularsubject(String subject) {
        List<Student> all = studentDAO.getall();

        return all.stream()
                .filter(student -> student.getMarks().containsKey(subject))
                .max(Comparator.comparing(student -> student.getMarks().get(subject)))
                .map(Student::getName)
                .orElse("No student found for the given subject");
    }
}

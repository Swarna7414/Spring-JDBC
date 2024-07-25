package com.demo.Service;

import com.demo.DAO.Impl.StudentDAO;
import com.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public List<Student> sortedbygrade();

    public List<String> passedone(String subject);

    public List<String> failedone(String subject);

    public String topper();

    public String topperinpircticularsubject(String subject);
}

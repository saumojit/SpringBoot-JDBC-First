package com.example.JDBCApp.service;

import com.example.JDBCApp.model.Student;
import com.example.JDBCApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private StudentRepository repo ;

    @Autowired
    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }

    public StudentService() {
        System.out.println("StudentService Created ...");
    }

    public void addStudent(Student stu_object){
        System.out.println(stu_object);
        repo.save(stu_object);
    }

    public List<Student> getStudents() {
        System.out.println("Service layer for getStudents");
        return repo.findAll();
    }

}

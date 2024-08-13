package com.example.JDBCApp;

import com.example.JDBCApp.model.Student;
import com.example.JDBCApp.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JdbcAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcAppApplication.class, args);

		StudentService service = context.getBean(StudentService.class);
		Student stu = context.getBean(Student.class);
		stu.setRollNo(7);
		stu.setName("Fan");
		stu.setMarks(80);
		service.addStudent(stu);

		List<Student> studentList = service.getStudents();
		System.out.println(studentList);
	}

}

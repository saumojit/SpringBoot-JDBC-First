package com.example.JDBCApp.repository;

import com.example.JDBCApp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbc ;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public StudentRepository() {
        System.out.println("StudentRepository Created ...");
    }

    public void save(Student obj) {
        String sql_query="INSERT into STUDENT(rollno , name , marks) values(?,?,?)";
        int rows_added =jdbc.update(sql_query , obj.getRollNo() , obj.getName() , obj.getMarks());
        System.out.println("Student Data Added +" + rows_added);
    }

    public List<Student> findAll() {
//         Approach1 : Non-Lambda Approach
        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };

//       Approach2 : Lambda Expression
//        RowMapper<Student> rowMapper = ( rs, rowNum) -> {
//                Student s = new Student();
//                s.setRollNo(rs.getInt("rollno"));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt("marks"));
//                return s;
//        };


        String sql_query="SELECT * from STUDENT";
        List<Student> students = jdbc.query(sql_query , rowMapper);
        System.out.println("Student List Retrieved from DB ...");
        return students;
    }
}

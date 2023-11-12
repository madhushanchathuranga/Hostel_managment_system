package com.example.hostal.Service;
import com.example.hostal.Entity.Student;

public interface StudentService {
    Student saveStudent(Student student);

    Iterable<Student> getAllStudent();

    Student getStudentById(Integer id);
}


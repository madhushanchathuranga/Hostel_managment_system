package com.example.hostal.Service;

import com.example.hostal.Entity.Property;
import com.example.hostal.Entity.Student;
import com.example.hostal.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        super();
        this.studentRepository=studentRepository;
    }
    @Override
    public Student saveStudent(Student student) {
        return (Student) studentRepository.save(student);
    }
    @Override
    public Iterable<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }


    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElse(null);
    }

}

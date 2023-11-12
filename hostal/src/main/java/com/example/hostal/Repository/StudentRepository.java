package com.example.hostal.Repository;

import com.example.hostal.Entity.Property;
import com.example.hostal.Entity.Report;
import com.example.hostal.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM student ", nativeQuery = true)
    List<Student> findAllByStatus();
}

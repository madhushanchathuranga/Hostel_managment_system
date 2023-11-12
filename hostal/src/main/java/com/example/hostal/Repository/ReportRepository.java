package com.example.hostal.Repository;

import com.example.hostal.Entity.Complaint;
import com.example.hostal.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = "SELECT * FROM resolvedcomplaint ", nativeQuery = true)
    List<Report> findAllByStatus();
}

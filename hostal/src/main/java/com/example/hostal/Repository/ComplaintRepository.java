package com.example.hostal.Repository;

import com.example.hostal.Entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Query(value = "SELECT * FROM complaint WHERE status = NULL", nativeQuery = true)
    List<Complaint> findAllByStatus();

}
package com.example.hostal.Repository;

import com.example.hostal.Entity.Complaint;
import com.example.hostal.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    @Query(value = "SELECT * FROM item", nativeQuery = true)
    List<Complaint> findAllByStatus();
}

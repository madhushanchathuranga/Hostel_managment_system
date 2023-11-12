package com.example.hostal.Service;

import com.example.hostal.Entity.Complaint;

public interface ComplaintService {
    Complaint saveComplaint(Complaint complaint);

    Iterable<Complaint> getAllComplaint();

    Complaint getComplaintById(Long id);
}

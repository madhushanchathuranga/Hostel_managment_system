package com.example.hostal.Service;

public interface ComplaintService {
    Complaint saveComplaint(Complaint complaint);

    Iterable<Complaint> getAllComplaint();

    Complaint getComplaintById(Long id);
}

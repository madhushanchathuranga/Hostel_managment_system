package com.example.hostal.Service;

import com.example.hostal.Entity.Report;

public interface ReportService {
    Report saveReport(Report report);

    Iterable<Report> getAllReport();

    Report getReportById(Long id);
}

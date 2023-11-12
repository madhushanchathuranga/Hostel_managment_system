package com.example.hostal.Service;

import com.example.hostal.Entity.Report;
import com.example.hostal.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository){
        super();
        this.reportRepository=reportRepository;
    }
    @Override
    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }
    @Override
    public Iterable<Report> getAllReport() {
        return (List<Report>) reportRepository.findAll();
    }


    @Override
    public Report getReportById(Long id) {
        Optional<Report> reportOptional = reportRepository.findById(id);
        return reportOptional.orElse(null);
    }
}

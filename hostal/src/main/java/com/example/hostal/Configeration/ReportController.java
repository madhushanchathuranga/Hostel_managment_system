
package com.example.hostal.Configeration;

import com.example.hostal.Entity.Report;
import com.example.hostal.Service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportServiceImpl reportService;


    @GetMapping("/view")
    @ResponseBody
    public ResponseEntity<List<Report>> listReport() {
        Iterable<Report> reportList = reportService.getAllReport();
        return ResponseEntity.ok((List<Report>) reportList);
    }

}


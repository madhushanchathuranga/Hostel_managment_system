package com.rhms.hms_backend.Controllers;


import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Models.Room_assignment;
import com.rhms.hms_backend.Services.ComplainService;
import com.rhms.hms_backend.Util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/complaints")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @GetMapping("/view")
    @ResponseBody
    public ResponseEntity<List<Complain>> listComplains() {
        Iterable<Complain> complainList = complainService.getAllComplain();
        return ResponseEntity.ok((List<Complain>) complainList);
    }


    @PostMapping("/complainSave")
    public ResponseEntity<String> saveComplain(Complain complain, @RequestParam("image") MultipartFile multipartFile) {
        try {
            if (!multipartFile.isEmpty()) {
                String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
                complain.setImageName(filename);
                Complain savedComplain = complainService.SaveComplain(complain);
                String uploadPath = "images/" + savedComplain.getId();

                FileUploadUtil.saveFile(uploadPath, filename, multipartFile);
            } else {
                if (complain.getImageFile().isEmpty()) {
                    complain.setImageFile(null);
                }
                complainService.SaveComplain(complain);
            }

            return ResponseEntity.ok("Complain saved successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving Complain: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Complain> getComplaineById(@PathVariable Long id) {
        Complain complain = complainService.getComplainById(id);
        if (complain == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(complain);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComplain(@PathVariable Long id) {
        try {
            complainService.deleteComplainById(id);
            return ResponseEntity.ok("Complaint deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while deleting complain: " + e.getMessage());
        }
    }



    @GetMapping("/perDay")
    public List<Object[]> findAllComplaintPerDate() {
        return complainService.findAllComplaint();
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateComplain(@PathVariable("id") Long id, @RequestBody Complain complain) {
        Complain existingComplain = complainService.getComplainById(id);
        if (existingComplain != null) {
            existingComplain.setStatus(complain.getStatus());
            existingComplain.setApproved_date(complain.getApproved_date());


            Complain updatedComplainObj = complainService.updateComplain(existingComplain);
            return ResponseEntity.ok(updatedComplainObj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping("/Aview")
    @ResponseBody
    public ResponseEntity<List<Complain>> listApprovedComplain() {
        Iterable<Complain> approvedList = complainService.ApprovedComplain();
        return ResponseEntity.ok((List<Complain>) approvedList);
    }

    @GetMapping("/wardenView")
    @ResponseBody
    public ResponseEntity<List<Complain>> listComplainWarden() {
        Iterable<Complain> approvedList = complainService.ComplaintWardenView();
        return ResponseEntity.ok((List<Complain>) approvedList);
    }

    @GetMapping("/deanView")
    @ResponseBody
    public ResponseEntity<List<Complain>> listComplainDean() {
        Iterable<Complain> approvedList = complainService.ComplaintDeanView();
        return ResponseEntity.ok((List<Complain>) approvedList);
    }



    @GetMapping("/complainByUserId")
    public ResponseEntity<List<Complain>> getComplainById(@RequestParam String uid) {
        List<Complain> complains = complainService.getComplainByuid(uid);
        if (complains != null && !complains.isEmpty()) {
            return ResponseEntity.ok(complains);
        } else {
            // You can customize the response for empty results, for example, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getcomplain")
    public List<Complain> getUidComplain(@RequestParam String uid) {
        return complainService.findcomplain(uid);
    }


    @GetMapping("/dailyComplain")
    public List<Complain> CreateTodayComplaintView() {
        return complainService.CreateTodayComplaintView();
    }

    @GetMapping("/totalComplains")
    public int getTotalComplains() {
        return complainService.getTotalComplains();
    }

    @GetMapping("/getPendingComplaintCount")
    public int getPendingComplaintCount() {
        return complainService.getPendingComplaintCount();
    }



}

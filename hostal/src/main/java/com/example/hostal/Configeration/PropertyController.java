package com.example.hostal.Configeration;


import com.example.hostel.Entity.Property;
import com.example.hostel.Service.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyServiceImpl propertyService;

    @PostMapping("/saveData")
    public ResponseEntity<String> saveProperty(@RequestBody Property property) {
        try {
            // Save complaint to the database
            propertyService.saveProperty(property);
            return ResponseEntity.ok("Propery saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving Property: " + e.getMessage());
        }
    }
}

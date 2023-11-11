package com.example.hostal.Configeration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "admindashboard";
    }

    @GetMapping("/complaint")
    public String complain() {
        return "complaint";
    }

    @GetMapping("/complainview")
    public String complainview() {
        return "complaintsview";
    }

    @GetMapping("/report")
    public String report() {
        return "reports";
    }

    @GetMapping("/property")
    public String propery() {
        return "property";
    }

    @GetMapping("/student")
    public String student() {
        return "sturegister";
    }
}




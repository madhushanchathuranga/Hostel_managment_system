package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Configurations.AccessRequest;
import com.rhms.hms_backend.Configurations.AccessResponse;
import com.rhms.hms_backend.Configurations.RegisterRequests;
import com.rhms.hms_backend.Dto.nvBarDetails;
import com.rhms.hms_backend.Models.Users;
import com.rhms.hms_backend.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthControll {

    private final AuthService authService;
/////////
@Autowired
PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<AccessResponse> register(@RequestBody RegisterRequests request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")

    public ResponseEntity<AccessResponse>login(@RequestBody AccessRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }



    @GetMapping("/CurrentUser")
    public nvBarDetails getCurrentUser(){  //Getting the CurrentUser username Using Authentication Interface that comes with Spring Security
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String fname=authentication.getName();
        return new nvBarDetails(fname);
    }

    @GetMapping("/UserProfile")
    public ResponseEntity<Users> getCurrentUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user_index = authentication.getName();
        Users userProfile = authService.getUserByIndex(user_index);

        if (userProfile != null) {
            return new ResponseEntity<>(userProfile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

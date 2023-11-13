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
    
package com.techtitans.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techtitans.tms.model.AuthRequest;
import com.techtitans.tms.model.Teachers;
import com.techtitans.tms.services.AuthService;
import com.techtitans.tms.wrapper.AuthResponses;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    //teacher login
    @PostMapping("/teacher/auth/login")
    public AuthResponses authenticateTeacher(@RequestBody AuthRequest authRequest) {
        boolean isAuthenticated = authService.authenticateTeacher(authRequest.getUsername(), authRequest.getPassword());

        if (isAuthenticated) {
            return new AuthResponses(true, "Login successful");
        } else {
            return new AuthResponses(false, "Invalid credentials");
        }
    }

    //student login
    @PostMapping("/student/auth/login")
    public AuthResponses authenticateStudent(@RequestBody AuthRequest authRequest) {
        boolean isAuthenticated = authService.authenticateStudent(authRequest.getUsername(), authRequest.getPassword());

        if (isAuthenticated) {
            return new AuthResponses(true, "Login successful");
        } else {
            return new AuthResponses(false, "Invalid credentials");
        }
    }

}

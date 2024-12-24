package com.serviceusers.controllers;

import lombok.RequiredArgsConstructor;
import com.serviceusers.entities.security.AuthenticationResponse;
import com.serviceusers.entities.User;
import com.serviceusers.services.security.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }



}


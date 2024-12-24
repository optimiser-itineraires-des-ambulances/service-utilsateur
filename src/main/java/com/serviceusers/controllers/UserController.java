package com.serviceusers.controllers;

import com.serviceusers.dto.UserDTO;
import com.serviceusers.entities.User;
import com.serviceusers.services.UserDetailsServiceImp;
import com.serviceusers.services.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserDetailsServiceImp userDetailsServiceImp;

    @GetMapping("admin/users")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userDetailsServiceImp.getAllUsers());
    }

    @GetMapping("admin/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userDetailsServiceImp.getUserById(id).orElseThrow());
    }

    @PatchMapping("admin/users/{id}")
    public ResponseEntity<User> editUserById(@PathVariable Long id , @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userDetailsServiceImp.editUserById(id,userDTO));
    }
}

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
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("ambulancier/{id}")
    public ResponseEntity<User> getAmbulancierById(@PathVariable Long id){
        return ResponseEntity.ok(userDetailsServiceImp.getUserById(id).orElseThrow());
    }

    @PatchMapping("admin/users/{id}")
    public ResponseEntity<User> editUserById(@PathVariable Long id , @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userDetailsServiceImp.editUserById(id,userDTO));
    }

    // Endpoint pour récupérer le total des utilisateurs
    @GetMapping("/total")
    public long getTotalUsers() {
        return userDetailsServiceImp.getTotalUsers();
    }


    // Créer un nouvel user
    @PostMapping("/admin/users")
    public ResponseEntity<User> addUser(@RequestBody User hopital) {
        User createdHopital = userDetailsServiceImp.addUser(hopital);
        return ResponseEntity.ok(createdHopital);
    }


    // Supprimer un user par son ID

    @DeleteMapping("/admin/users/{id}")
    public ResponseEntity<Void> deleteHopital(@PathVariable Long id) {
        userDetailsServiceImp.deleteUser(id); // Call the instance method
        return ResponseEntity.noContent().build();
    }



}

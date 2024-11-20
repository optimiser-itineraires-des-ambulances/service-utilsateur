package com.serviceusers.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("3ew from CLIENT secured url");
    }

    @GetMapping("/admin/demo")
    public ResponseEntity<String> admiDemo(){
        return ResponseEntity.ok("3ew from ADMIN secured url");
    }
}

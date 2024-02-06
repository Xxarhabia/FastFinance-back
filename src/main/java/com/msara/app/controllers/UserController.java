package com.msara.app.controllers;

import com.msara.app.models.entities.UserEntity;
import com.msara.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/owner")
    public ResponseEntity<?> createOwner(@RequestBody UserEntity user) {
        try {
            userService.createOwner(user);
            return ResponseEntity.ok().body("Owner has been created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody UserEntity user) {
        try {
            userService.createEmployee(user);
            return ResponseEntity.ok().body("Employee has been created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

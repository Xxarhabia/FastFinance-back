package com.msara.app.controllers;

import com.msara.app.models.entities.UserEntity;
import com.msara.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/client")
    public ResponseEntity<?> createClient(@RequestBody UserEntity user) {
        try {
            userService.createClient(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Client has been created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/assign-role")
    public ResponseEntity<?> assignRole(int idUser, int idRole) {
        try {
            userService.assignRoleToUser(idUser, idRole);
            return ResponseEntity.status(HttpStatus.OK).body("Role has been assigned successfully");
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

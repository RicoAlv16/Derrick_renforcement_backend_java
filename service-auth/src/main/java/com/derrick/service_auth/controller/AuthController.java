package com.derrick.service_auth.controller;

import com.derrick.service_auth.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    // Endpoint pour générer un token
    @PostMapping("/token")
    public ResponseEntity<String> generateToken(@RequestParam String username) {
        try {
            String token = jwtService.generateToken(username);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de la génération du token : " + e.getMessage());
        }
    }

}



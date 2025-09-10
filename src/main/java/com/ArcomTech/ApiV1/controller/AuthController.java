package com.ArcomTech.ApiV1.controller;

import com.ArcomTech.ApiV1.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @PostMapping("/login")
    public String login(@RequestBody User request) {
        // Valida usuario y contraseña (ejemplo simplificado)
        if ("user".equals(request.getMail()) && "password".equals(request.getPassword())) {
            return Jwts.builder()
                    .setSubject(request.getMail())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                    .signWith(SignatureAlgorithm.HS256, "tu_clave_secreta")
                    .compact();
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}


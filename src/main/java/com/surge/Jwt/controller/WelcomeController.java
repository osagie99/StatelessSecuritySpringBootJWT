package com.surge.Jwt.controller;

import com.surge.Jwt.entity.AuthRequest;
import com.surge.Jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public String welcome() {
        return "Welcome to Spring security";
    }

    @PostMapping("authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new UsernameNotFoundException("User" + authRequest.getUsername() + " does not exist.");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}

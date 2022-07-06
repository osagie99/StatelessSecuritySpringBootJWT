package com.surge.Jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class HelloController {

    @GetMapping("user")
    public String user() {
        return "Hello User";
    }

    @GetMapping("admin")
    public String admin() {
        return "Hello Admin";
    }
}

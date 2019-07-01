package com.example.springstudy.controller;

import com.example.springstudy.service.DemoService;
import com.example.springstudy.model.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {
    private DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/user/{name}")
    public String getUserEmail(@PathVariable String name) {
        return demoService.getUserEmail(name);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUser() {
        return demoService.getAllUser();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserDto body) {
        String name = body.getName();
        String email = body.getEmail();
        System.out.println(body.toString());
        demoService.saveUser(name, email);
    }
}

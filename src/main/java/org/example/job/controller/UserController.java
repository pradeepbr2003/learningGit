package org.example.job.controller;

import org.example.job.dto.JobSeekerDTO;
import org.example.job.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<JobSeekerDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}

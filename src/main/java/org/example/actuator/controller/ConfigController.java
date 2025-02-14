package org.example.actuator.controller;

import org.example.common.config.UserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/config")
@RestController
public class ConfigController {

    @Autowired
    private UserConfiguration userConfig;

    @GetMapping("/skill")
    String[] skill() {
        return userConfig.getSkillSet();
    }

    @GetMapping("/username")
    String[] username() {
        return userConfig.getUsername();
    }
}

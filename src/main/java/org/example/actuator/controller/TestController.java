package org.example.actuator.controller;

import org.example.actuator.dto.ActuatorLink;
import org.example.actuator.dto.ActuatorTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    String helloWorld() {
        return "Message for you! : Hello World";
    }

    @PostMapping
    List<String> getActuatorLinks(@RequestBody ActuatorLink actuatorLink) throws FileNotFoundException {
        return actuatorLink.get_links().stream().map(ActuatorTemplate::getHref).toList();
    }
}

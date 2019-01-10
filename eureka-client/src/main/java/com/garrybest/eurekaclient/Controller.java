package com.garrybest.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String greet(@RequestParam String name) {
        return "Hi " + name + ", I am from port: " + port;
    }
}

package com.garrybest.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return ribbonService.ribbonService(name);
    }
}

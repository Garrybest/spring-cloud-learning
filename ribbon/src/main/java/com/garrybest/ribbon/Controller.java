package com.garrybest.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi() {
        return ribbonService.ribbonService();
    }
}

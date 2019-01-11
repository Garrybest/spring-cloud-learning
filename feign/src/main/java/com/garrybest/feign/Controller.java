package com.garrybest.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    FeignService feignService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "fr", required = false) String name) {
        return feignService.sayHi(name);
    }
}

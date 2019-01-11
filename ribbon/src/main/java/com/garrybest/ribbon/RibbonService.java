package com.garrybest.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    public String ribbonService(String name) {
        return restTemplate.getForObject("http://DEMO-SERVICE/hello?name=" + name, String.class);
    }
}

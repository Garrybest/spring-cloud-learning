package com.garrybest.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ribbonError")
    public String ribbonService(String name) {
        return restTemplate.getForObject("http://DEMO-SERVICE/hi?name=" + name, String.class);
    }

    public String ribbonError(String name) {
        return "Hi " + name + ", something went wrong.";
    }
}

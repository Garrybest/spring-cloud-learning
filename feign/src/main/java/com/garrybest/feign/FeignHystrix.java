package com.garrybest.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignHystrix implements EurekaClientFeign {

    @Override
    public String sayHiFromClientOne(String name) {
        return "Hi " + name + ", something went wrong.";
    }
}

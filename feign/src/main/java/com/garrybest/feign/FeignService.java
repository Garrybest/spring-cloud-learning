package com.garrybest.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignService {

    @Autowired
    EurekaClientFeign eurekaClientFeign;

    public String sayHi(String name) {
        return eurekaClientFeign.sayHiFromClientOne(name);
    }
}

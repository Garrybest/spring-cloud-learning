package com.garrybest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "DEMO-SERVICE", configuration = FeignConfig.class)
public interface EurekaClientFeign {

    @GetMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}

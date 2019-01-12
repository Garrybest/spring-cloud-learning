package com.garrybest.zuul;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ZuulToken {

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}

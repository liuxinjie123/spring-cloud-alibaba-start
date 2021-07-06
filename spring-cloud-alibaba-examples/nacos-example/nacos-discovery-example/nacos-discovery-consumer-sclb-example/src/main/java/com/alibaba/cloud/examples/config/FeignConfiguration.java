package com.alibaba.cloud.examples.config;

import com.alibaba.cloud.examples.service.EchoServiceFallback;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

}

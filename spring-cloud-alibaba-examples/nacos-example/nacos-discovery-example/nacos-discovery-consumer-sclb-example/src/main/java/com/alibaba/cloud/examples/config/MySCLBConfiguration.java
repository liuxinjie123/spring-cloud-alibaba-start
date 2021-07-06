package com.alibaba.cloud.examples.config;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(value = "service-provider", configuration = MyLoadBalancerConfiguration.class)
public class MySCLBConfiguration {
}

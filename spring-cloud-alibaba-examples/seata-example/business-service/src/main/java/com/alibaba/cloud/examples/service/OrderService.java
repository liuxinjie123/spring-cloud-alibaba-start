package com.alibaba.cloud.examples.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("order-service")
public interface OrderService {

    @PostMapping(path = "/order")
    String order(@RequestParam("userId") String userId,
                 @RequestParam("commodityCode") String commodityCode,
                 @RequestParam("orderCount") int orderCount);

}

package com.xch.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-03-24 10:06
 */
@RestController
@Slf4j
public class OrderController {
    @Value("${server-url.nacos-user-service}")
    private String paymentUrl;
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id")Long id){
        return restTemplate.getForObject(paymentUrl+"/payment/nacos/"+id,String.class);
    }
}

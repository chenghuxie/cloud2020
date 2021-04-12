package com.xch.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author xiech
 * @create 2021-03-18 15:20
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "payment/zk")
    public String payment(){
        return "springcloud with zk："+serverPort+"\t"+UUID.randomUUID().toString();
    }
}

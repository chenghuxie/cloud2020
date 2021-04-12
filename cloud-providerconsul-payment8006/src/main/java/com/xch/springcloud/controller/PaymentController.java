package com.xch.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author xiech
 * @create 2021-03-19 10:22
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "payment/consul")
    public String payment(){
        return "springcloud with consul："+serverPort+"\t"+UUID.randomUUID().toString();
    }
}

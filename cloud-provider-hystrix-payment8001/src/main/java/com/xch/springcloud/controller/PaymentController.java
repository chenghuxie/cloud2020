package com.xch.springcloud.controller;

import com.xch.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-03-19 16:35
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        return paymentService.paymentInfo_ok(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id){
        return paymentService.paymentInfo_timeout(id);
    }

    @GetMapping("/payment/circurt/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        return this.paymentService.paymentCircuitBreaker(id);
    }
}

package com.xch.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-03-18 16:55
 */
@RestController
@Slf4j
public class OrderController {

 private static final String INVOKE_URL="http://consul-provider-payment";
 @Resource
 private RestTemplate restTemplate;


 @GetMapping("/consumer/payment/consul")
 public String paymentInfo(){
     String result=restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
     return result;
 }
}

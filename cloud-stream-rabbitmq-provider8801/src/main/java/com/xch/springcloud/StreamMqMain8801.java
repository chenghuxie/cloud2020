package com.xch.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiech
 * @create 2021-03-23 14:21
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8801.class,args);
    }
}

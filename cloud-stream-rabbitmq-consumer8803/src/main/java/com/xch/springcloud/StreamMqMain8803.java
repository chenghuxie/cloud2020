package com.xch.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiech
 * @create 2021-03-23 14:51
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8803.class,args);
    }
}

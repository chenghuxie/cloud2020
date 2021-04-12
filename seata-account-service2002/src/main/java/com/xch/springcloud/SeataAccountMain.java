package com.xch.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiech
 * @create 2021-04-09 9:41
 */
@SpringBootApplication(exclude  = DataSourceAutoConfiguration.class )
@EnableFeignClients
@EnableDiscoveryClient
public class SeataAccountMain {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain.class,args);
    }
}

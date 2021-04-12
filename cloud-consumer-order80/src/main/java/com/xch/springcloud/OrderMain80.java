package com.xch.springcloud;

import com.xch.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author xiech
 * @create 2021-03-17 10:19
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class) //自定义负载均衡策略
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}

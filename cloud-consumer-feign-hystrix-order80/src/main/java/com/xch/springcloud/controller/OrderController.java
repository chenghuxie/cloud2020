package com.xch.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.xch.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-03-19 17:04
 */
@RestController
@Slf4j
/*@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")*/
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        return paymentFeignService.paymentInfo_ok(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties ={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    } )*/
   @HystrixCommand
    public String paymentInfo_timeout(@PathVariable("id") Long id){
        return paymentFeignService.paymentInfo_timeout(id);
    }

    @GetMapping("/consumer/payment/circurt/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Long id){
       return this.paymentFeignService.paymentCircuitBreaker(id);
    }


    public String paymentTimeOutFallbackMethod(@PathVariable("id") Long id){
        return "线程池:"+Thread.currentThread().getName()+"对方支付系统繁忙，请稍后再试！,id:"+id;
    }

    public String paymentGlobalFallbackMethod(){
        return "Global异常处理信息，请稍后再试！";
    }

}

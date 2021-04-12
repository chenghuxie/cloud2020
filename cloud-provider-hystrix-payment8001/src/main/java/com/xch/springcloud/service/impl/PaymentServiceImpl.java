package com.xch.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xch.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author xiech
 * @create 2021-03-19 16:35
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    public String paymentInfo_ok(Long id) {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_ok,id:"+id;
    }


/*    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties ={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "4000")
    } )*/
    public String paymentInfo_timeout(Long id) {
     /*   try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
     int i=10/0;
         return "线程池:"+Thread.currentThread().getName()+"paymentInfo_timeout,id:"+id;
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数超过峰值，熔断器将会从关闭到开启
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id){
        if(id<0){
            throw new RuntimeException("************id 不能负数");
        }
        String serialNumber=IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }


    public String paymentInfo_TimeOutHandler(Long id){
        return "线程池:"+Thread.currentThread().getName()+"系统繁忙，请稍后再试！,id:"+id;
    }

    public String paymentCircuitBreaker_fallback(Long id){
        return "id 不能为负数，请稍后再试，id："+id;
    }
}

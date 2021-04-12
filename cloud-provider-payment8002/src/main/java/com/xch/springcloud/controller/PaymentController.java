package com.xch.springcloud.controller;

import com.xch.springcloud.entities.CommonResult;
import com.xch.springcloud.entities.Payment;
import com.xch.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author xiech
 * @create 2021-03-16 16:12
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.insert(payment);
        if(result>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
     Payment payment=this.paymentService.queryById(id);
     if(payment!=null){
         return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
     }else{
         return new CommonResult(444,"查询失败",null);
     }
    }

    @GetMapping(value = "/payment/lb")
    public String payment(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}

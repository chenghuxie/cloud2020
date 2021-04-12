package com.xch.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xch.springcloud.entities.CommonResult;
import com.xch.springcloud.entities.Payment;
import com.xch.springcloud.service.PaymentFallbackService;
import com.xch.springcloud.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-03-24 10:06
 */
@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${server-url.nacos-user-service}")
    private String paymentUrl;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private PaymentFeginService paymentFeginService;


    @GetMapping("/consumer/fallback/{id}")
   /* @SentinelResource(value = "fallback")*/
   /* @SentinelResource(value = "fallback",fallback = "handlerFallback")*/
  /*  @SentinelResource(value = "fallback",blockHandler = "blockHandler")*/
/*    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")*/
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult fallback(@PathVariable("id")Long id){
          CommonResult<Payment> result= restTemplate.getForObject(paymentUrl+"/payment/get/"+id,CommonResult.class,id);
          if(id==4){
              throw new IllegalArgumentException("IllegalArgumentException,非法参数异常。。。。");
          }else if(result.getData()==null){
              throw new NullPointerException("NullPointerException,该id没有对应记录，空指针异常");
          }
          return result;
    }

    public CommonResult handlerFallback(@PathVariable("id") Long id,Throwable e){
        Payment payment=new Payment(id,"null");
        return new CommonResult<Payment>(444,"兜底异常handlerFallback,exception内容："+e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable("id") Long id,BlockException e){
        Payment payment=new Payment(id,"null");
        return new CommonResult<Payment>(445,"兜底异常blockHandler,exception内容："+e.getMessage(),payment);
    }


    @GetMapping("/consumer/openfeign/{id}")
    public CommonResult openfeign(@PathVariable("id")Long id){
        return paymentFeginService.queryById(id);
    }


}

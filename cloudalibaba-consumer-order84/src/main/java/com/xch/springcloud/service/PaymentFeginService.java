package com.xch.springcloud.service;

import com.xch.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiech
 * @create 2021-03-26 15:51
 */
@FeignClient(value = "nacos-provider-payment",fallback = PaymentFallbackService.class)
public interface PaymentFeginService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id);
}

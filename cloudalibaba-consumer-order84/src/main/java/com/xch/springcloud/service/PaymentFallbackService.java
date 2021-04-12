package com.xch.springcloud.service;

import com.xch.springcloud.entities.CommonResult;
import com.xch.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author xiech
 * @create 2021-03-26 15:54
 */
@Component
public class PaymentFallbackService implements PaymentFeginService {
    public CommonResult queryById(Long id) {
        return new CommonResult(444,"服务降级返回，-----PaymentFallbackService",new Payment(id,"error"));
    }
}

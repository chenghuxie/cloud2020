package com.xch.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xiech
 * @create 2021-03-19 17:55
 */
@Component
public class PaymentFallbackService implements PaymentFeignService {
    public String paymentInfo_ok(Long id) {
        return "---------PaymentFallbackService fall back paymentInfo_ok";
    }

    public String paymentInfo_timeout(Long id) {
        return "---------PaymentFallbackService fall back paymentInfo_timeout";
    }

    public String paymentCircuitBreaker(Long id) {
        return "---------PaymentFallbackService fall back paymentCircuitBreaker";
    }
}

package com.xch.springcloud.service;

/**
 * @author xiech
 * @create 2021-03-19 16:34
 */
public interface PaymentService {

    String paymentInfo_ok(Long id);

    String paymentInfo_timeout(Long id);

    String paymentCircuitBreaker(Long id);
}

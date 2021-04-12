package com.xch.springcloud.service;

import com.xch.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiech
 * @create 2021-03-16 16:10
 */
public interface PaymentService {
    public int insert(Payment payment);
    public Payment queryById(@Param(value = "id") Long id);
}

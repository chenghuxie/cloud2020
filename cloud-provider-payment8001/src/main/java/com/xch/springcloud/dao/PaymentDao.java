package com.xch.springcloud.dao;

import com.xch.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiech
 * @create 2021-03-16 15:31
 */
@Mapper
public interface PaymentDao {
    public int insert(Payment payment);
    public Payment queryById(@Param(value = "id") Long id);
}

package com.xch.springcloud.service.impl;

import com.xch.springcloud.dao.PaymentDao;
import com.xch.springcloud.entities.Payment;
import com.xch.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-03-16 16:11
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int insert(Payment payment) {
        return this.paymentDao.insert(payment);
    }

    public Payment queryById(Long id) {
        return this.paymentDao.queryById(id);
    }
}

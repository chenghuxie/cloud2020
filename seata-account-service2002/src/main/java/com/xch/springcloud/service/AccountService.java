package com.xch.springcloud.service;

import java.math.BigDecimal;

/**
 * @author xiech
 * @create 2021-04-09 9:55
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}

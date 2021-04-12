package com.xch.springcloud.service;

/**
 * @author xiech
 * @create 2021-04-09 10:20
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}

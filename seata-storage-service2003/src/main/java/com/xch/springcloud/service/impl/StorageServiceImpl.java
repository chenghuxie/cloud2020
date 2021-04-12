package com.xch.springcloud.service.impl;

import com.xch.springcloud.dao.StorageDao;
import com.xch.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-04-09 10:21
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;
    public void decrease(Long productId, Integer count) {
        this.storageDao.decrease(productId,count);
    }
}

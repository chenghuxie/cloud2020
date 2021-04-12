package com.xch.springcloud.controller;

import com.xch.springcloud.entities.CommonResult;
import com.xch.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-04-09 10:16
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        this.storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功！");
    }
}

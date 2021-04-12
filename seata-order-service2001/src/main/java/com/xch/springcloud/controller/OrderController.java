package com.xch.springcloud.controller;

import com.xch.springcloud.domain.Order;
import com.xch.springcloud.entities.CommonResult;
import com.xch.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-04-08 17:25
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;
    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功！");
    }

}

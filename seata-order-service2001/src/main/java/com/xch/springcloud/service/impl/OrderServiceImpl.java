package com.xch.springcloud.service.impl;

import com.xch.springcloud.dao.OrderDao;
import com.xch.springcloud.domain.Order;
import com.xch.springcloud.service.AccountService;
import com.xch.springcloud.service.OrderService;
import com.xch.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-04-08 17:11
 */
@Service
@Slf4j
public class OrderServiceImpl  implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
      log.info("开始新建订单");
      orderDao.create(order);
      log.info("------->订单微服务开始调用库存，做减库存 start");
      storageService.decrease(order.getProductId(),order.getCount());
      log.info("------->订单微服务开始调用库存，做减库存 end");
      log.info("---------->订单微服务调用账户，做扣减操作 start");
      accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---------->订单微服务调用账户，做扣减操作 end");
        log.info("---------->修改订单状态 start");
      orderDao.update(order.getUserId(),0);
        log.info("---------->修改订单状态 end");
    }

}

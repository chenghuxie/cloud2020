package com.xch.springcloud.controller;

import com.xch.springcloud.entities.CommonResult;
import com.xch.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author xiech
 * @create 2021-04-09 9:54
 */
@RestController
@Slf4j
public class AccountController {
    @Resource
    private AccountService accountService;
    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        this.accountService.decrease(userId,money);
        return new CommonResult(200,"扣减用户余额成功!");
    }
}

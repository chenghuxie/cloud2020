package com.xch.springcloud.controller;

import com.xch.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiech
 * @create 2021-03-23 14:31
 */
@RestController
@Slf4j
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/send/message")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}

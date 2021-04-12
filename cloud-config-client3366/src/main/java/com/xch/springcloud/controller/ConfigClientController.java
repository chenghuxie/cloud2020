package com.xch.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiech
 * @create 2021-03-23 10:33
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;
  @GetMapping("/config/info")
  public String getConfigInfo(){
      return "serverPort:"+serverPort+"\t\n\n configInfo:"+configInfo;
  }
}

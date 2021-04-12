package com.xch.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiech
 * @create 2021-04-08 17:28
 */
@Configuration
@MapperScan({"com.xch.springcloud.dao"})
public class MybatisConfig {
}

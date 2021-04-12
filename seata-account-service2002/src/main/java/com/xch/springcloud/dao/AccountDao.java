package com.xch.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author xiech
 * @create 2021-04-09 9:40
 */
@Mapper
public interface AccountDao {
    int decrease(@Param(value = "userId") Long userId, @Param(value = "money") BigDecimal money);
}

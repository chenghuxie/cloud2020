package com.xch.springcloud.dao;

import com.xch.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiech
 * @create 2021-04-08 16:58
 */
@Mapper
public interface OrderDao {
    void create(Order order);
    void update(@Param("userId")Long userId,@Param("status") Integer status);
}

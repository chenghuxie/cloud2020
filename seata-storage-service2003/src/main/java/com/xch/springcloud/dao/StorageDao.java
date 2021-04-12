package com.xch.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiech
 * @create 2021-04-09 10:16
 */
@Mapper
public interface StorageDao {
    int decrease(@Param(value = "productId") Long productId, @Param(value = "count") Integer count);
}

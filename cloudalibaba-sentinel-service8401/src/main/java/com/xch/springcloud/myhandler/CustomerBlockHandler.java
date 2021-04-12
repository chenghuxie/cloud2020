package com.xch.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xch.springcloud.entities.CommonResult;


/**
 * @author xiech
 * @create 2021-03-26 13:44
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException e){
        return new CommonResult(444,"客户自定义限流异常-----------1");
    }

    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(444,"客户自定义限流异常-----------2");
    }
}

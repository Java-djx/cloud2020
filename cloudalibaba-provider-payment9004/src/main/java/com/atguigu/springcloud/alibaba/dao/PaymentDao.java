package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 86166
 * @create 2022年10月27日19:05:08
 */
@Mapper
public interface PaymentDao
{
    /**
     * 新增
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 查询单个实体类
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
 
 
 
 

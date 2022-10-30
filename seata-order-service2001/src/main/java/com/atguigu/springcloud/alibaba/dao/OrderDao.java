package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: djx
 * @createTime: 2022/10/29 11:39
 */
@Mapper
@Repository
public interface OrderDao {

    /**
     * 创建订单
     * @param order
     * @return
     */
    public Integer create(Order order);


    /**
     * 修改订单状态
     * @param userId
     * @param status
     */
    public Integer update(@Param("userId") Long userId, @Param("status") Integer status);

}

package com.itheima.health.dao;

import com.itheima.health.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * com.itheima.health.dao
 *
 * @Author: chengHan
 * @Date: 2021/1/11 16:20
 */
public interface OrderSettingDao {
    /**
     * 通过日期查询预约设置信息，日期唯一
     * @param orderDate
     * @return
     */
    OrderSetting findByOrderDate(Date orderDate);

    /**
     * 添加预约设置信息
     * @param os
     */
    void add(OrderSetting os);

    /**
     * 更新最大预约数
     * @param os
     */
    void updateNumber(OrderSetting os);

    /**
     * 通过月份查询预约设置信息
     * @param month
     * @return
     */
    List<Map<String, Integer>> getOrderSettingByMonth(String month);
}

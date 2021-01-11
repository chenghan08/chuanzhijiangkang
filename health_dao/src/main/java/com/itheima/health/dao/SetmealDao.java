package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * com.itheima.health.dao
 *
 * @Author: chengHan
 * @Date: 2021/1/8 20:01
 */
public interface SetmealDao {
    /**
     * 添加套餐
     *
     * @param setmeal
     */
    void add(Setmeal setmeal);

    /**
     * 添加套餐与检查组的关系
     *
     * @param setmealId    套餐的id
     * @param checkgroupId 检查组的id
     */
    void addSetmealCheckGroup(@Param("setmealId") Integer setmealId, @Param("checkgroupId") Integer checkgroupId);

    /**
     * 分页条件查询
     *
     * @param queryString
     * @return
     */
    Page<Setmeal> findPage(String queryString);

    /**
     * 通过id查询套餐
     *
     * @param id
     * @return
     */
    Setmeal findById(int id);

    /**
     * 查询选中的检查组id集合
     *
     * @param id
     * @return
     */
    List<Integer> findCheckGroupIdsBySetmealId(int id);

    /**
     * 更新套餐
     *
     * @param setmeal
     */
    void update(Setmeal setmeal);

    /**
     * 删除旧关系
     *
     * @param id
     */
    void deleteSetmealCheckGroup(Integer id);

    /**
     * 统计该套餐被订单使用的个数
     *
     * @param id
     * @return
     */
    int findCountBySetmealId(int id);

    /**
     * 删除套餐
     *
     * @param id
     */
    void deleteById(int id);

    /**
     * 查询套餐上的所有图片
     * @return
     */
    List<String> findImgs();

}

package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.exception.MyException;
import com.itheima.health.pojo.Setmeal;

import java.util.List;

/**
 * com.itheima.health.service
 *
 * @Author: chengHan
 * @Date: 2021/1/8 20:00
 */
public interface SetmealService {
    /**
     * 添加套餐
     *
     * @param setmeal
     * @param checkgroupIds
     */
    Integer add(Setmeal setmeal, Integer[] checkgroupIds);

    /**
     * 分页条件查询
     *
     * @return
     */
    PageResult<Setmeal> findPage(QueryPageBean queryPageBean);

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
     * 修改套餐
     *
     * @param setmeal
     * @param checkgroupIds
     */
    void update(Setmeal setmeal, Integer[] checkgroupIds);

    /**
     * 通过id删除套餐
     *
     * @param id
     */
    void deleteById(int id) throws MyException;

    /**
     * 定时清理七牛上的垃圾图片
     * @return
     */
    List<String> findImgs();

    /**
     * 查询所有的套餐
     * @return
     */
    List<Setmeal> findAll();

    /**
     * 通过id查询套餐详情
     * @param id
     * @return
     */
    Setmeal findDetailById(int id);
}

package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.exception.MyException;
import com.itheima.health.pojo.CheckGroup;

import java.util.List;

/**
 * com.itheima.health.service
 *
 * @Author: chengHan
 * @Date: 2021/1/7 20:09
 */
public interface CheckGroupService {

    /**
     * 添加检查组
     * @param checkGroup  检查组信息
     * @param checkitemIds 选中的检查项id数组
     */
    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    /**
     * 检查组分页查询
     * @param queryPageBean
     * @return
     */
    PageResult<CheckGroup> findPage(QueryPageBean queryPageBean);

    /**
     * 通过id查询检查组
     * @param id
     * @return
     */
    CheckGroup findById(int id);

    /**
     * 通过检查组id查询选中的检查项
     * @param id
     * @return
     */
    List<Integer> findCheckItemIdsByCheckGroupId(int id);

    /**
     * 修改检查组
     * @param checkGroup 检查组信息
     * @param checkitemIds 选中的检查项id数组
     * @return
     */
    void update(CheckGroup checkGroup, Integer[] checkitemIds);

    /**
     * 通过id删除检查组
     * @param id
     */
    void deleteById(int id) throws MyException;
}

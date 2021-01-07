package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * com.itheima.health.dao
 *
 * @Author: chengHan
 * @Date: 2021/1/5 22:29
 */
public interface CheckItemDao {
    /**
     * 查询所有
     * @return
     */
    List<CheckItem> findAll();

    /**
     * 添加
     * @param checkItem
     */
    void add(CheckItem checkItem);

    /**
     * 检查项的分页查询
     * @param queryString
     * @return
     */
    Page<CheckItem> findByCondition(String queryString);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    CheckItem findById(int id);

    /**
     * 更新检查项
     * @param checkItem
     */
    void update(CheckItem checkItem);

    /**
     * 统计使用了这个检查项的个数
     * @param id
     * @return
     */
    int findCountByCheckItemId(int id);

    /**
     * 通过id删除该检查项
     * @param id
     */
    void deleteById(int id);
}

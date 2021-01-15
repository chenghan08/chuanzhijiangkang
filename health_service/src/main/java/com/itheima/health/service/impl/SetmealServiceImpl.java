package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.itheima.health.dao.SetmealDao;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.exception.MyException;
import com.itheima.health.pojo.Setmeal;
import com.itheima.health.service.SetmealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.itheima.health.service.impl
 *
 * @Author: chengHan
 * @Date: 2021/1/8 20:00
 */
@Service(interfaceClass = SetmealService.class)
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;

    /**
     * 添加套餐
     *
     * @param setmeal
     * @param checkgroupIds
     */
    @Override
    @Transactional
    public Integer add(Setmeal setmeal, Integer[] checkgroupIds) {
        // 先添加套餐
        setmealDao.add(setmeal);
        // 获取套餐的id
        Integer setmealId = setmeal.getId();
        // 遍历checkgroupIds数组
        for (Integer checkgroupId : checkgroupIds) {
            // 添加套餐与检查组的关系
            setmealDao.addSetmealCheckGroup(setmealId, checkgroupId);
        }
        //事务控制
        return setmealId;
    }

    /**
     * 分页条件查询
     *
     * @return
     */
    @Override
    public PageResult<Setmeal> findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        //条件查询
        if (StringUtil.isNotEmpty(queryPageBean.getQueryString())) {
            //模糊查询
            queryPageBean.setQueryString("%" + queryPageBean.getQueryString() + "%");
        }
        Page<Setmeal> setmealPage = setmealDao.findPage(queryPageBean.getQueryString());
        return new PageResult<Setmeal>(setmealPage.getTotal(), setmealPage.getResult());
    }

    /**
     * 通过id查询套餐
     *
     * @param id
     * @return
     */
    @Override
    public Setmeal findById(int id) {
        return setmealDao.findById(id);
    }

    /**
     * 查询选中的检查组id集合
     *
     * @param id
     * @return
     */
    @Override
    public List<Integer> findCheckGroupIdsBySetmealId(int id) {
        return setmealDao.findCheckGroupIdsBySetmealId(id);
    }

    /**
     * 修改套餐
     *
     * @param setmeal
     * @param checkgroupIds
     */
    @Override
    @Transactional
    public void update(Setmeal setmeal, Integer[] checkgroupIds) {
        //更新套餐
        setmealDao.update(setmeal);
        //删除旧关系
        setmealDao.deleteSetmealCheckGroup(setmeal.getId());
        //遍历添加新关系
        if (null != checkgroupIds) {
            for (Integer checkgroupId : checkgroupIds) {
                setmealDao.addSetmealCheckGroup(setmeal.getId(), checkgroupId);
            }
        }
        //事务控制

    }

    /**
     * 通过id删除套餐
     *
     * @param id
     */
    @Override
    public void deleteById(int id) {
        // 判断该套餐是否被订单使用
        int count = setmealDao.findCountBySetmealId(id);
        if (count > 0) {
            // 如果被订单使用了，则需要报错，抛出异常
            throw new MyException("该套餐被订单使用了，不能删除！");
        }
        // 如果没有被使用，则需要先删除套餐与检查组的关系
        setmealDao.deleteSetmealCheckGroup(id);
        // 删除套餐
        setmealDao.deleteById(id);
    }

    /**
     * 查询套餐上的所有图片
     * @return
     */
    @Override
    public List<String> findImgs() {
        return setmealDao.findImgs();
    }

    /**
     * 查询所有的套餐
     * @return
     */
    @Override
    public List<Setmeal> findAll() {
        return setmealDao.findAll();
    }

    /**
     * 通过id查询套餐详情
     * @param id
     * @return
     */
    @Override
    public Setmeal findDetailById(int id) {
        return setmealDao.findDetailById(id);
    }
}

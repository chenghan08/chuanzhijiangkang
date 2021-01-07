package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * com.itheima.health.controller
 *
 * @Author: chengHan
 * @Date: 2021/1/5 21:48
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    /**
     * 订阅检查项服务
     */
    @Reference
    private CheckItemService checkItemService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll() {
        List<CheckItem> list = checkItemService.findAll();
        //将数据封装到Result里面
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, list);
    }

    /**
     * 添加检查项
     *
     * @param checkItem
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody CheckItem checkItem) {
        //调用服务添加
        checkItemService.add(checkItem);
        //返回操作的结果
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    /**
     * 检查项的分页查询
     * @param queryPageBean
     * @return
     */
    @PostMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        //调用服务层查询
        PageResult <CheckItem> pageResult = checkItemService.findPage(queryPageBean);
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,pageResult);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public Result findById(int id){
        CheckItem checkItem = checkItemService.findById(id);
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
    }

    /**
     * 更新检查项
     *
     * @param checkItem
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody CheckItem checkItem) {
        //调用服务更新
        checkItemService.update(checkItem);
        //返回操作的结果
        return new Result(true, MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @PostMapping("/deleteById")
    public Result deleteById(int id){
        checkItemService.deleteById(id);
        return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }
}

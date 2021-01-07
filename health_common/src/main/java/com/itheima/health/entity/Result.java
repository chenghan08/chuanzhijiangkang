package com.itheima.health.entity;

import java.io.Serializable;

/**
 * 封装返回结果
 * @author Aluckys
 */
public class Result implements Serializable{
    /**
     * 执行结果，true为执行成功 false为执行失败
     */
    private boolean flag;
    /**
     * 返回结果信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;
    public Result(boolean flag, String message) { // 保存、修改保存
        super();
        this.flag = flag;
        this.message = message;
    }

    public Result(boolean flag, String message, Object data) {// 查询回显
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
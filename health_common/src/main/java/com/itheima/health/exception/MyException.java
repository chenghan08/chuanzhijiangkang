package com.itheima.health.exception;

/**
 * com.itheima.health.exception
 *
 * @Author: chengHan
 * @Date: 2021/1/7 17:07
 */

/**
 * 自定义异常:
 *      1.友好的提示
 *      2.区分异常的类型(业务,系统,未知)
 *      3.终止已知不符合业务逻辑代码的继续执行
 * @author Aluckys
 */
public class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }
}

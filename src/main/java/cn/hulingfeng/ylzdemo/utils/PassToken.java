package cn.hulingfeng.ylzdemo.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 无需认证注解类
 * @author hlf
 * @title: PassToken
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/25 9:09
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}

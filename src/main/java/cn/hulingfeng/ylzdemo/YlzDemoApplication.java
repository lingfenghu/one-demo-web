package cn.hulingfeng.ylzdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 */
@SpringBootApplication
@MapperScan("cn.hulingfeng.ylzdemo.mapper") //mapper扫包
public class YlzDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YlzDemoApplication.class, args);
    }

}

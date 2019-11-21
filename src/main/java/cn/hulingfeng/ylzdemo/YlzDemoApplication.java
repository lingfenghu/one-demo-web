package cn.hulingfeng.ylzdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.hulingfeng.ylzdemo.mapper"})
public class YlzDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YlzDemoApplication.class, args);
    }

}

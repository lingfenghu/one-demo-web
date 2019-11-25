package cn.hulingfeng.ylzdemo.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hlf
 * @title: User
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 15:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
}

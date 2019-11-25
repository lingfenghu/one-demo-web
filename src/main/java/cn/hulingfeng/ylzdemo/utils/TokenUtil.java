package cn.hulingfeng.ylzdemo.utils;

import cn.hulingfeng.ylzdemo.model.po.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @author hlf
 * @title: TokenUtil
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 23:05
 */
public class TokenUtil {
    //我的密钥
    public static final String SECRET = "cn.edu.jmu.hulingfeng";
    //有效时间
//    public static final long TTL = 60*60*24*7;

    /**
     * 简单生成token
     * @param user
     * @return
     */
    public static String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getUsername())
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }
}

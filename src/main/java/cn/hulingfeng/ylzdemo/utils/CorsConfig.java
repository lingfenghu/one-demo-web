package cn.hulingfeng.ylzdemo.utils;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 * @author hlf
 * @title: CorsConfig
 * @projectName ylzDemo
 * @date 2019/11/23 20:51
 */
@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //保留会话session
        config.setAllowCredentials(true);
        // 设置你要允许的网站域名，*表示任意域名 http://localhost:8888前端项目接口
        config.addAllowedOrigin("*");
        // 表示任意头部信息
        config.addAllowedHeader("*");
        // 对所有方法有效
        config.addAllowedMethod("*");
        // 对所有接口有效
        source.registerCorsConfiguration("/**", config);
        // 注册过滤器
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        // 这个顺序很重要，为避免麻烦请设置在最前
        bean.setOrder(0);
        return bean;
    }
}

package com.example.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 测试nacos配置中心
 * 直接用配置类来读取nacos里的配置支持热更新，如果是使用@Value()来读取的配置 则需要注解@RefreshScope来处理
 */
@Data
@ConfigurationProperties("userper")
@Component
public class UserPer {
    private String name;
    private int age;
}

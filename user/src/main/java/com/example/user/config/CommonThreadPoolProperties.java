package com.example.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Data
@ConfigurationProperties(prefix = "common.thread")
@Component
@PropertySource(value = "classpath:threadconfig.properties")
public class CommonThreadPoolProperties {

    /**
     * 核心线程数
     */
    private int corePoolSize;
    /**
     * 最大线程数
     */
    private int maxPoolSize;
    /**
     * 队列大小
     */
    private int queueCapacity;
    private int keepAliveTime;
}

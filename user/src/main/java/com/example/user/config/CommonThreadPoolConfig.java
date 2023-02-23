package com.example.user.config;

import com.alibaba.nacos.common.utils.ThreadFactoryBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
@Configuration
//@EnableConfigurationProperties(CommonThreadPoolProperties.class)
public class CommonThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(CommonThreadPoolProperties properties) {
        return new ThreadPoolExecutor(properties.getCorePoolSize(), properties.getMaxPoolSize(), properties.getKeepAliveTime(), TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(properties.getQueueCapacity()), new ThreadFactoryBuilder()
                .build());
    }
}

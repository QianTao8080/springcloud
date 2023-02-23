package com.example.user.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        interceptor.setOverflow(true);
        mybatisPlusInterceptor.addInnerInterceptor(interceptor);
        return mybatisPlusInterceptor;
    }

    /**
     *
     *
     手动创建线程池，效果会更好哦。
     Inspection info:
     线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明：Executors返回的线程池对象的弊端如下：
     1）FixedThreadPool和SingleThreadPool:
       允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
     2）CachedThreadPool:
       允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。

     Positive example 1：
     //org.apache.commons.lang3.concurrent.BasicThreadFactory
     ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
     new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());



     Positive example 2：
     ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
     .setNameFormat("demo-pool-%d").build();

     //Common Thread Pool
     ExecutorService pool = new ThreadPoolExecutor(5, 200,
     0L, TimeUnit.MILLISECONDS,
     new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

     pool.execute(()-> System.out.println(Thread.currentThread().getName()));
     pool.shutdown();//gracefully shutdown



     Positive example 3：
     <bean id="userThreadPool"
     class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
     <property name="corePoolSize" value="10" />
     <property name="maxPoolSize" value="100" />
     <property name="queueCapacity" value="2000" />

     <property name="threadFactory" value= threadFactory />
     <property name="rejectedExecutionHandler">
     <ref local="rejectedExecutionHandler" />
     </property>
     </bean>
     //in code
     userThreadPool.execute(thread);


     *
     * */
    @Bean
    public ExecutorService commonThreadPool() {
        Executors.newFixedThreadPool(5);
        return null;
    }
}

package com.deer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.deer")
public class DeerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DeerApplication.class,args);
    }
    /**
     *新增此方法
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(DeerApplication.class);
    }
}

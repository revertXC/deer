package com.deer.xxlJob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.deer")
public class XXLJOBApplication{
    public static void main(String[] args) {
        SpringApplication.run(XXLJOBApplication.class,args);
    }

}

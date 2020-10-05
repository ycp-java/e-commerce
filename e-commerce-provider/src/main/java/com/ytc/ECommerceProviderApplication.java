package com.ytc;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("com.ytc.mapper")
public class ECommerceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceProviderApplication.class, args);
    }

}

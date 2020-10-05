package com.ytc;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class ECommerceTrolleyConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceTrolleyConsumerApplication.class, args);
    }

}
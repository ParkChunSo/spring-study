package com.example.springstudy.config;

import com.example.springstudy.model.dto.BeanDto;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BeanDto BeanDto() {
        return new BeanDto();
    }
}

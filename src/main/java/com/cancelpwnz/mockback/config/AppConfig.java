package com.cancelpwnz.mockback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

@Configuration
public class AppConfig {

    @Bean
    FormatterRegistry addReg(FormatterRegistry registry){
        registry.addConverter(new StringToSortConverter());
        return registry;
    }

}

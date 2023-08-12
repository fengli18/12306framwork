package com.hw.basespringbootstarter.config;

import com.hw.basespringbootstarter.safe.FastJsonMode;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfigure{
    @Bean
    @ConditionalOnProperty(value = "framework.fastjson.safa-mode",havingValue = "true")
    @ConditionalOnMissingBean
    public FastJsonMode fastJsonMode(){
        return new FastJsonMode();
    }
}

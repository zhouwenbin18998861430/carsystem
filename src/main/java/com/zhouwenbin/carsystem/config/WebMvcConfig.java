package com.zhouwenbin.carsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${file.localtion}")
    private String localtion;

    @Value("${file.tomcatUrl}")
    private String tomcatUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(tomcatUrl).addResourceLocations(localtion);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}


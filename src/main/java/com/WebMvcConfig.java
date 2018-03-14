package com;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.GzipResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // webjars �̒�` js bootstrap
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
                    .resourceChain(false) // ������ WebJarsResourceResolver ���L���������B
                    .addResolver(new GzipResourceResolver()); // gz �t�@�C���ւ̃A�N�Z�X�L�����B
        
   }
    
}

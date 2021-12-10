package com.zs.xinguanmaterialmanager.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceprterConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getHandlerInterceptor(){
        return  new MyIntercepter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getHandlerInterceptor())       //注册拦截器
                .addPathPatterns("/**")       //拦截的路径
                .excludePathPatterns("/aaa/*","/bbb/*");      //不拦截的路径
    }
}
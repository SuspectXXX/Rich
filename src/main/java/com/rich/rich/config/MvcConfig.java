package com.rich.rich.config;

import com.rich.rich.component.MyHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/index");
//    }
}


package com.hiwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.hiwork.interceptor.AutoLoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
  @Autowired
  AutoLoginInterceptor autoLoginInterceptor;
  
  @Override 
  public void addInterceptors(InterceptorRegistry registry) { 
    registry.addInterceptor(autoLoginInterceptor);
  }

}

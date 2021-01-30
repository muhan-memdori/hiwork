package com.hiwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.hiwork.interceptor.AutoLoginInterceptor;
import com.hiwork.service.WorkerService;

public class WebMvcConfig implements WebMvcConfigurer{
  @Autowired
  WorkerService workerService;
  
  @Override 
  public void addInterceptors(InterceptorRegistry registry) { 
    registry.addInterceptor(new AutoLoginInterceptor(workerService));
  }

}

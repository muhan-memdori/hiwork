package com.hiwork.config;

import org.springframework.context.annotation.Bean;
import nz.net.ultraq.thymeleaf.LayoutDialect;

public class LayoutConfig {
  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }
}

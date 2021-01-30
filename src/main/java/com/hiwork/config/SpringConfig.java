package com.hiwork.config;

import com.hiwork.repository.CalenderRepository;
import com.hiwork.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hiwork.repository.BoardRepository;
import com.hiwork.service.BoardService;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class SpringConfig {
  private final BoardRepository boardRepository;
  private final CalenderRepository calenderRepository;

  @Autowired
  public SpringConfig(BoardRepository boardRepository, CalenderRepository calenderRepository) {
    this.boardRepository = boardRepository;
    this.calenderRepository = calenderRepository;
  }

  @Bean
  public BoardService boardService() {
    return new BoardService(boardRepository);
  }

  @Bean
  public CalenderService calenderService() {
    return new CalenderService(calenderRepository);
  }
  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }
}

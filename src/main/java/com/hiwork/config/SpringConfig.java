package com.hiwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hiwork.repository.BoardRepository;
import com.hiwork.repository.WorkerRepository;
import com.hiwork.service.BoardService;
import com.hiwork.service.WorkerService;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class SpringConfig {
  private final BoardRepository boardRepository;
  private final WorkerRepository workerRepository;

  @Autowired
  public SpringConfig(BoardRepository boardRepository, WorkerRepository workerRepository) {
    this.boardRepository = boardRepository;
    this.workerRepository = workerRepository;
  }

  @Bean
  public BoardService boardService() {
    return new BoardService(boardRepository);
  }

  @Bean
  public WorkerService workerService() {
    return new WorkerService(workerRepository);
  }
  
  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }
}

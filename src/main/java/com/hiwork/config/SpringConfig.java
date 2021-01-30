package com.hiwork.config;

import com.hiwork.repository.CalenderRepository;
import com.hiwork.service.CalenderService;
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
  private final CalenderRepository calenderRepository;
  private final WorkerRepository workerRepository;

  @Autowired
  public SpringConfig(BoardRepository boardRepository, CalenderRepository calenderRepository, WorkerRepository workerRepository) {
    this.boardRepository = boardRepository;
    this.calenderRepository = calenderRepository;
    this.workerRepository = workerRepository;
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
  public WorkerService workerService() {
    return new WorkerService(workerRepository);
  }
  
  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }
}

package com.hiwork.config;

import com.hiwork.repository.*;
import com.hiwork.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  private final BoardRepository boardRepository;
  private final WorkerRepository workerRepository;
  private final CalendarRepository calendarRepository;
  private final CInfoRepository cInfoRepository;
  private final CommentRepository commentRepository;

  @Autowired
  public SpringConfig(
      BoardRepository boardRepository, 
      WorkerRepository workerRepository, 
      CalendarRepository calendarRepository,
      CInfoRepository cInfoRepository,
      CommentRepository commentRepository) {
    this.boardRepository = boardRepository;
    this.workerRepository = workerRepository;
    this.calendarRepository = calendarRepository;
    this.cInfoRepository = cInfoRepository;
    this.commentRepository = commentRepository;
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
  public CalendarService calendarService() {
    return new CalendarService(calendarRepository);
  }

  @Bean
  public CInfoService companyService() {
    return new CInfoService(cInfoRepository);
  }

  @Bean
  public CommentService commentRepository() {
    return new CommentService(commentRepository);
  }

}

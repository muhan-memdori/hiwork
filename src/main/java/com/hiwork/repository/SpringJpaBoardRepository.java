package com.hiwork.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hiwork.domain.Board;

public interface SpringJpaBoardRepository extends JpaRepository<Board, Integer>, BoardRepository {
  Board findByNo(int no);
  List<Board> findAll(String keyword);
  
}

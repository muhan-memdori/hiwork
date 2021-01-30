package com.hiwork.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.hiwork.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
  @Modifying
  @Query("UPDATE Board b SET b.viewCount = b.viewCount + 1 where b.no = :no")
  void updateViewCount(int no);
}

package com.hiwork.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hiwork.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

  @Transactional
  @Modifying
  @Query("UPDATE Board b SET b.viewCount = b.viewCount + 1 where b.no = :no")
  void updateViewCount(@Param("no") int no);

  @Transactional
  @Modifying
  @Query("UPDATE Board b SET b.status = 0 where b.no = :no")
  void inactive(@Param("no") int no);

  List<Board> findAllByStatusOrderByRegistrationDateDesc(@Param("status") int status);

  Optional<Board> findByNoAndStatus(@Param("no") int no, @Param("status") int status);
}

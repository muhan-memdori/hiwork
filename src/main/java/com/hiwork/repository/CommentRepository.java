package com.hiwork.repository;

import com.hiwork.domain.Board;
import com.hiwork.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

  @Transactional
  @Modifying
  @Query("UPDATE Comment c SET c.status = 0 where c.no = :no")
  void inactive(@Param("no") int no);

  List<Comment> findAllByBoardNoByStatusOrderByRegistrationDateDesc(@Param("boardNo") int boardNo, @Param("status") int status);
}

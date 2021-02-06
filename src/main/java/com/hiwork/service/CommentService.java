package com.hiwork.service;

import com.hiwork.domain.Board;
import com.hiwork.domain.Comment;
import com.hiwork.repository.BoardRepository;
import com.hiwork.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

public class CommentService {

  private final CommentRepository commentRepository;
  BoardRepository boardRepository;

  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public int delete(int no) {
    commentRepository.inactive(no);
    return 1;
  }

  public Comment add(Comment comment) {
    return commentRepository.save(comment);
  }

  public List<Comment> list(int boardNo) {
    return commentRepository.findAllByBoardNoByStatusOrderByRegistrationDateDesc(boardNo, 1);
  }

  public Comment update(Comment comment) {
    return commentRepository.save(comment);
  }
}

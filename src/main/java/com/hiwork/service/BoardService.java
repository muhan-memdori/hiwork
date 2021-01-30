package com.hiwork.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hiwork.domain.Board;
import com.hiwork.repository.BoardRepository;

public class BoardService {

  BoardRepository boardRepository;

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }


  public int delete(int no) {
    boardRepository.inactive(no);
    return 1;
  }

  public Board add(Board board) {
    return boardRepository.save(board);
  }

  public List<Board> list() {
    return boardRepository.findAllByStatusOrderByRegistrationDateDesc(1);
  }

  public Optional<Board> get(int no) {
    Optional<Board> board = boardRepository.findByNoAndStatus(no, 1);
    board.ifPresent(b -> {
      boardRepository.updateViewCount(b.getNo());
    });
    return board;
  }

  public Board update(Board board) {
    return boardRepository.save(board);
  }

}

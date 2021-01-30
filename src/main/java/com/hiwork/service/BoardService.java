package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.Board;
import com.hiwork.repository.BoardRepository;

public class BoardService {

  BoardRepository boardRepository;

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  public int delete(int no) {
    return boardRepository.delete(no);
  }

  @Override
  public int add(Board board) {
    return boardRepository.insert(board);
  }

  @Override
  public List<Board> list() {
    return boardRepository.findAll(null);
  }

  @Override
  public List<Board> list(String keyword)  {
    return boardRepository.findAll(keyword);
  }

  @Override
  public Board get(int no) {
    Board board = boardRepository.findByNo(no);
    if (board != null) {
      boardRepository.updateViewCount(no);
    }
    return board;
  }

  @Override
  public int update(Board board) {
    return boardRepository.update(board);
  }
}

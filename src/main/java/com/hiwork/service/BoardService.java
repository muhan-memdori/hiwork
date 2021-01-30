package com.hiwork.service;

import java.util.List;
import java.util.Optional;
import com.hiwork.domain.Board;
import com.hiwork.repository.BoardRepository;

public class BoardService {

  BoardRepository boardRepository;

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }
<<<<<<< HEAD
//
//  @Override
//  public int delete(int no) {
//    return boardRepository.delete(no);
//  }
//
//  @Override
//  public int add(Board board) {
//    return boardRepository.insert(board);
//  }
//
//  @Override
//  public List<Board> list() {
//    return boardRepository.findAll(null);
//  }
//
//  @Override
//  public List<Board> list(String keyword)  {
//    return boardRepository.findAll(keyword);
//  }
//
//  @Override
//  public Board get(int no) {
//    Board board = boardRepository.findByNo(no);
//    if (board != null) {
//      boardRepository.updateViewCount(no);
//    }
//    return board;
//  }
//
//  @Override
//  public int update(Board board) {
//    return boardRepository.update(board);
//  }
=======

  public int delete(int no) {
    boardRepository.inactive(no);
    return 1;
  }

  public Board add(Board board) {
    return boardRepository.save(board);
  }

  public List<Board> list() {
    return boardRepository.findAll();
  }

  public Optional<Board> get(int no) {
    Optional<Board> board = boardRepository.findById(no);
    board.ifPresent(b -> {
      boardRepository.updateViewCount(b.getNo());
    });
    return board;
  }

  public Board update(Board board) {
    return boardRepository.save(board);
  }
>>>>>>> b5952133fb58d5d835389f26ccea28f8860b9ea3
}

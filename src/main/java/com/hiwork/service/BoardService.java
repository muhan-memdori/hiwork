package com.hiwork.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import com.hiwork.domain.Board;
import com.hiwork.repository.BoardRepository;

public class BoardService {

  BoardRepository boardRepository;
  private static final int BLOCK_PAGE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 수
  private static final int PAGE_POST_COUNT = 4; // 한 페이지에 존재하는 게시글 수

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }
  
  Queue<Integer> sq = new LinkedList<>();
  sq.offer();


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

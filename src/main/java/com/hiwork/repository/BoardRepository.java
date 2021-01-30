package com.hiwork.repository;

import java.util.List;
import com.hiwork.domain.Board;

public interface BoardRepository {

  List<Board> findAll(String keyword);

  int delete(int no);

  int insert(Board board);

  void updateViewCount(int no);

  int update(Board board);

}

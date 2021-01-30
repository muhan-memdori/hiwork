package com.hiwork.repository;

import java.util.List;
import com.hiwork.domain.Board;

public interface BoardDao {

  List<Board> findAll() throws Exception;

}

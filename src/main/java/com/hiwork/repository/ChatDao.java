package com.hiwork.repository;

import java.util.List;
import com.hiwork.domain.Chat;

public interface ChatDao {

  List<Chat> find() throws Exception;

}








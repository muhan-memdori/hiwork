package com.hiwork.repository;

import java.util.List;
import com.hiwork.domain.VKind;

public interface VKindDao {

  List<VKind> find() throws Exception;
}

package com.hiwork.service;

import java.util.List;
import java.util.Optional;
import com.hiwork.domain.CInfo;
import com.hiwork.repository.CInfoRepository;

public class CInfoService {

  CInfoRepository cInfoRepository;

  public CInfoService(CInfoRepository cInfoRepository) {
    this.cInfoRepository = cInfoRepository;
  }

  public List<CInfo> list() {
    return cInfoRepository.findAll();
  }

  public Optional<CInfo> get(int no) {
    Optional<CInfo> cInfo = cInfoRepository.findById(no);
    return cInfo;
  }
}

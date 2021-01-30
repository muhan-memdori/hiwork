package com.hiwork.service;

import java.util.List;
import java.util.Optional;
import com.hiwork.domain.Worker;
import com.hiwork.repository.WorkerRepository;

public class WorkerService {

  WorkerRepository workerRepository;

  public WorkerService(WorkerRepository workerRepository) {
    this.workerRepository = workerRepository;
  }

  public int delete(int no) {
    workerRepository.inactive(no);
    return 1;
  }

  public Worker add(Worker worker) {
    return workerRepository.save(worker);
  }

  public List<Worker> list() {
    return workerRepository.findAll();
  }

  public Optional<Worker> get(long no) {
    Optional<Worker> worker = workerRepository.findById(no);
    return worker;
  }

  public Worker update(Worker worker) {
    return workerRepository.save(worker);
  }

  public Worker get(String email, String password) {
    return workerRepository.findByEmailAndPassword(email, password);
  }
}

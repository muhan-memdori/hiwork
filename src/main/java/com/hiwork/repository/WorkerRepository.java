package com.hiwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.hiwork.domain.Worker;
import org.springframework.data.repository.query.Param;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
  @Modifying
  @Query("UPDATE Worker w SET w.status = 0 where w.no = :no")
  void inactive(long no);

  Worker findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}

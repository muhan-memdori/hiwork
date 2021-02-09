package com.hiwork.repository;

import com.hiwork.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hiwork.domain.Calendar;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Integer>{

    @Transactional
    @Modifying
    @Query("UPDATE Calendar c SET c.status = 0 where c.calCode = :calcode")
    void inactive(@Param("calcode") int calCode);

    List<Calendar> findAllByStatus(@Param("status") int status);

}

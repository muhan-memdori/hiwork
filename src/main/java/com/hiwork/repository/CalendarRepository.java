package com.hiwork.repository;

import com.hiwork.domain.Board;
import com.hiwork.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {

}

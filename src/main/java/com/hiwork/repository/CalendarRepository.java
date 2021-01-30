package com.hiwork.repository;

import com.hiwork.domain.Board;
import com.hiwork.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long>{
}

package com.hiwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hiwork.domain.Calendar;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Integer>{
}

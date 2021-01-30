package com.hiwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hiwork.domain.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {

}

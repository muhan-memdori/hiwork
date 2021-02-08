package com.hiwork.service;

import com.hiwork.domain.Board;
import com.hiwork.domain.Calendar;
import com.hiwork.repository.CalendarRepository;

import java.util.List;

public class CalendarService {

    CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }
    public List<Calendar> list() {
        return calendarRepository.findAll();
    }
    public Calendar add(Calendar calendar) {
        return calendarRepository.save(calendar);
    }
}

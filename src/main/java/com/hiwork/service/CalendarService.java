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
        return calendarRepository.findAllByStatus(1);
    }
    public Calendar add(Calendar calendar) {
        return calendarRepository.save(calendar);
    }
    public Calendar update(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public int delete(int calCode) {
        calendarRepository.inactive(calCode);
        return 1;
    }
}

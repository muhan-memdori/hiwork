package com.hiwork.service;

import com.hiwork.domain.Calender;
import com.hiwork.repository.CalenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class CalenderService  {

    CalenderRepository calenderRepository;

    public CalenderService(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    public List<Calender> list() {
        return calenderRepository.findAll();
    }
}

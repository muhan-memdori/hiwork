package com.hiwork.controller;

import com.hiwork.domain.Board;
import com.hiwork.domain.Calendar;
import com.hiwork.domain.Worker;
import com.hiwork.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
@RequestMapping("/calendar")
@SessionAttributes("loginUser")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping("list")
    public void list(Model model) throws Exception {
        model.addAttribute("list", calendarService.list());
    }

    @PostMapping("add")
    public String add(
            Calendar calendar,
            Long sdtMillis,
            Long edtMillis,
            @ModelAttribute("loginUser") Worker loginUser) throws Exception {
        calendar.setWriter(loginUser);
        calendar.setSdt(new Date(sdtMillis));
        calendar.setEdt(new Date(edtMillis));
        calendar.setContent("기본 내용");
        calendarService.add(calendar);
        return "redirect:list";
    }

    @PostMapping("update")
    public String update(
            Calendar calendar,
            Long sdtMillis,
            Long edtMillis,
            @ModelAttribute("loginUser") Worker loginUser) throws Exception {
        calendar.setWriter(loginUser);
        calendar.setSdt(new Date(sdtMillis));
        calendar.setEdt(new Date(edtMillis));
        calendar.setContent("기본 내용");
        if (calendarService.update(calendar) == null) {
            throw new Exception("해당 번호의 스케줄이 없습니다.");
        }
        return "redirect:list";
    }
}

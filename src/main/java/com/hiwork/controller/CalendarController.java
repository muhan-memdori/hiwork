package com.hiwork.controller;

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
            String title,
            String place,
            Long sdt,
            Long edt,
            int status,
            @ModelAttribute("loginUser") Worker loginUser) throws Exception {
        Calendar calendar = new Calendar();
        calendar.setTitle(title);
        calendar.setPlace(place);
        calendar.setWriter(loginUser);
        calendar.setSdt(new Date(sdt));
        calendar.setEdt(new Date(edt));
        calendar.setStatus(status);
        calendar.setContent("기본 내용");
        calendarService.add(calendar);
        return "redirect:list";
    }
}

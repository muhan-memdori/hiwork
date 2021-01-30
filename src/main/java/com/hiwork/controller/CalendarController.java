package com.hiwork.controller;

import com.hiwork.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/calendar")
@SessionAttributes("loginUser")
public class CalendarController {

    @Autowired
    CalendarService calenderService;

    @GetMapping("list")
    public String list(Model model) throws Exception {
        model.addAttribute("list", calenderService.list());
        return "calendar/list";
    }

}

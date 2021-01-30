package com.hiwork.controller;

import com.hiwork.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//@Controller
@RequestMapping("/calender")
@SessionAttributes("loginUser")
public class CalenderController {

    @Autowired
    CalenderService calenderService;

    @GetMapping("list")
    public void list(Model model) throws Exception {
        model.addAttribute("list", calenderService.list());
    }

}

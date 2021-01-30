package com.hiwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/vacation")
@SessionAttributes("loginUser")
public class VacationController {

  @GetMapping("/form")
  public void form(Model model) {
  }

  @GetMapping("/add")
  public String add(Model model) {
    return "redirect:.";
  }

  @GetMapping("/delete")
  public String delete(Model model) {
    return "redirect:.";
  }

  @GetMapping("/update")
  public String update(Model model) {
    return "redirect:.";
  }

  @GetMapping("/list")
  public void list(Model model) throws Exception {
  }
}

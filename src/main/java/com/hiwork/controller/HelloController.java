package com.hiwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
  
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "자동리로드가 되나 안되나");
    return "hello";
  }
  
  @GetMapping("layout")
  public String layout(Model model) {
    model.addAttribute("data", "레이아웃이 만들어지나 안만들어지나");
    return "layout";
  }
}

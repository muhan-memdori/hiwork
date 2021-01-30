package com.hiwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.hiwork.service.CInfoService;

@Controller
@RequestMapping("/cinfo")
@SessionAttributes("loginUser")
public class CInfoController {

  @Autowired CInfoService cInfoService;

  @GetMapping("form")
  public void form() {

  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("list", cInfoService.list());
  }
}

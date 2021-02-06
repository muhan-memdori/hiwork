package com.hiwork.controller;

import com.hiwork.domain.Comment;
import com.hiwork.domain.Category;
import com.hiwork.domain.Worker;
import com.hiwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/comment")
@SessionAttributes("loginUser")
public class CommentController {

  @Autowired CommentService commentService;

  @GetMapping("form")
  public void form() {

  }

  @PostMapping("add")
  public String add(
      Comment comment,
      @ModelAttribute("loginUser") Worker loginUser) throws Exception {
    comment.setWriter(loginUser);
    commentService.add(comment);
    return "redirect:list";
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    if (commentService.delete(no) == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }

  @PostMapping("update")
  public String update(Comment comment) throws Exception {
    if (commentService.update(comment) == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }

}

package com.hiwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.hiwork.domain.Board;
import com.hiwork.domain.Worker;
import com.hiwork.service.BoardService;

@Controller
@RequestMapping("/board")
@SessionAttributes("loginUser")
public class BoardController {

  @Autowired BoardService boardService;

  
//  @GetMapping("form")
//  public void form() {
//
//  }
//
//  @PostMapping("add")
//  public String add(
//      Board board,
//      @ModelAttribute("loginUser") Worker loginUser) throws Exception {
//    board.setWriter(loginUser);
//    boardService.add(board);
//    return "redirect:list";
//  }
//
//  @GetMapping("delete")
//  public String delete(int no) throws Exception {
//    if (boardService.delete(no) == 0) {
//      throw new Exception("해당 번호의 게시글이 없습니다.");
//    }
//    return "redirect:list";
//  }
//
//  @GetMapping("detail")
//  public String detail(
//      int no,
//      @RequestParam(defaultValue = "1") int templateType,
//      Model model) throws Exception {
//
//    Board board = boardService.get(no);
//    if (board == null) {
//      throw new Exception("해당 번호의 게시글이 없습니다!");
//    }
//    model.addAttribute("board", board);
//
//    if (templateType == 2) {
//      return "ajax1/board/detail";
//    } else {
//      return "board/detail";
//    }
//  }
//
//  @GetMapping("list")
//  public void list(String keyword, Model model) throws Exception {
//    model.addAttribute("list", boardService.list(keyword));
//  }
//
//  @PostMapping("update")
//  public String update(Board board) throws Exception {
//    int count = boardService.update(board);
//    if (count == 0) {
//      throw new Exception("해당 번호의 게시글이 없습니다.");
//    }
//    return "redirect:list";
//  }
}

package com.hiwork.controller;

import java.util.List;
import java.util.Optional;

import com.hiwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hiwork.domain.Board;
import com.hiwork.domain.Category;
import com.hiwork.domain.Worker;
import com.hiwork.service.BoardService;

@Controller
@RequestMapping("/board")
@SessionAttributes("loginUser")
public class BoardController {

  @Autowired BoardService boardService;
  @Autowired CommentService commentService;

  @GetMapping("form")
  public void form() {

  }

  @PostMapping("add")
  public String add(
      Board board,
      int categoryNo,
      @ModelAttribute("loginUser") Worker loginUser) throws Exception {
    board.setWriter(loginUser);
    board.setCategory(new Category().setNo(categoryNo));
    boardService.add(board);
    return "redirect:list";
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    if (boardService.delete(no) == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }

  @GetMapping("{no}")
  public String detail(
      @PathVariable int no,
      Model model) throws Exception {

    Optional<Board> board = boardService.get(no);
    board.orElseThrow();
    model.addAttribute("board", board.get());
    model.addAttribute("comments", commentService.list(no));
    return "board/detail";
  }

  @GetMapping("list")
  public void list(
          Model model)
          throws Exception {

    model.addAttribute("boards", boardService.list());
  }

  @PostMapping("update")
  public String update(Board board, int categoryNo) throws Exception {
    board.setCategory(new Category().setNo(categoryNo));
    if (boardService.update(board) == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }

}

package com.hiwork.controller;

import java.util.Optional;
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
import com.hiwork.domain.Category;
import com.hiwork.domain.Worker;
import com.hiwork.service.BoardService;

@Controller
@RequestMapping("/board")
@SessionAttributes("loginUser")
public class BoardController {

  @Autowired BoardService boardService;

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

  @GetMapping("detail")
  public String detail(
      int no,
      Model model) throws Exception {

    Optional<Board> board = boardService.get(no);
    board.orElseThrow();
    model.addAttribute("board", board.get());
    return "board/detail";
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("list", boardService.list());
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

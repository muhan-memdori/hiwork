package com.hiwork.domain;

import java.util.Date;

// @Entity
public class Comment {
  // @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int no;
  private int boardNo;
  private int stage;
  private String content;
  private Date registrationDate;
  private Worker writer;
  private int momNo;
  private int status;

  public int getNo() {
    return no;
  }
  public Comment setNo(int no) {
    this.no = no;
    return this;
  }
  public int getBoardNo() {
    return boardNo;
  }
  public Comment setBoardNo(int boardNo) {
    this.boardNo = boardNo;
    return this;
  }
  public int getStage() {
    return stage;
  }
  public Comment setStage(int stage) {
    this.stage = stage;
    return this;
  }
  public String getContent() {
    return content;
  }
  public Comment setContent(String content) {
    this.content = content;
    return this;
  }
  public Date getRegistrationDate() {
    return registrationDate;
  }
  public Comment setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
    return this;
  }
  public Worker getWriter() {
    return writer;
  }
  public Comment setWriter(Worker writer) {
    this.writer = writer;
    return this;
  }
  public int getMomNo() {
    return momNo;
  }
  public Comment setMomNo(int momNo) {
    this.momNo = momNo;
    return this;
  }
  public int getStatus() {
    return status;
  }
  public Comment setStatus(int status) {
    this.status = status;
    return this;
  }

}

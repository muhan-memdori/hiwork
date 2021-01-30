package com.hiwork.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cms_cmtInfo")
public class Comment {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cno")
  private long no;

  @Column(name="bno")
  private int boardNo;

  private int stage;
  private String content;

  @Column(name="rdt")
  private Date registrationDate;

  @ManyToOne
  @JoinColumn(name ="wNo")
  private Worker writer;

  private int momNo;
  private int status;

  public long getNo() {
    return no;
  }

  public Comment setNo(long no) {
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

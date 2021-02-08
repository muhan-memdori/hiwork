package com.hiwork.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="cms_calender")
public class Calendar {

  public static final int OFFICIAL = 0;
  public static final int UNOFFICIAL = 1;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="calno")
  private int calCode;

  @ManyToOne(targetEntity=Worker.class, fetch=FetchType.LAZY)
  @JoinColumn(name ="wno")
  private Worker writer;

  private String title;
  private Date sdt;
  private Date edt;
  private String content;
  private String place;
  private int status;

  public int getCalCode() {
    return calCode;
  }
  public void setCalCode(int calCode) {
    this.calCode = calCode;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Date getSdt() {
    return sdt;
  }
  public void setSdt(Date sdt) {
    this.sdt = sdt;
  }
  public Date getEdt() {
    return edt;
  }
  public void setEdt(Date edt) {
    this.edt = edt;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getPlace() {
    return place;
  }
  public void setPlace(String place) {
    this.place = place;
  }
  public Worker getWriter() {
    return writer;
  }
  public void setWriter(Worker writer) {
    this.writer = writer;
  }
  public int getStatus() { return status; }
  public void setStatus(int status) { this.status = status; }


}

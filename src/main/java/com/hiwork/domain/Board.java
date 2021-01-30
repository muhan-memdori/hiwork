package com.hiwork.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="cms_blist")
public class Board {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="bno")
  private long no;
  
  private String title;
  
  @ManyToOne(targetEntity=Category.class, fetch=FetchType.LAZY)
  @JoinColumn(name ="ctno")
  private Category category;
  
  @Column(name="regidate", insertable = false)
  private Date registrationDate;
  
  @Column(name="vcount")
  private int viewCount;
  
  @Column(name="afile")
  private String attachedFile;
  
  @Column(name="fsize")
  private int fileSize;
  private String content;
  
  @ManyToOne(targetEntity=Worker.class, fetch=FetchType.LAZY)
  @JoinColumn(name ="wno")
  private Worker writer;
  private int status;

  public long getNo() {
    return no;
  }

  public Board setNo(long no) {
    this.no = no;
    return this;
  }

  public Category getCategory() {
    return category;
  }

  public Board setCategoryNo(Category category) {
    this.category = category;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Board setTitle(String title) {
    this.title = title;
    return this;
  }

  public Date getRegistrationDate() {
    return registrationDate;
  }

  public Board setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
    return this;
  }

  public int getViewCount() {
    return viewCount;
  }

  public Board setViewCount(int viewCount) {
    this.viewCount = viewCount;
    return this;
  }

  public String getAttachedFile() {
    return attachedFile;
  }

  public Board setAttachedFile(String attachedFile) {
    this.attachedFile = attachedFile;
    return this;
  }

  public int getFileSize() {
    return fileSize;
  }

  public Board setFileSize(int fileSize) {
    this.fileSize = fileSize;
    return this;
  }

  public String getContent() {
    return content;
  }

  public Board setContent(String content) {
    this.content = content;
    return this;
  }

  public Worker getWriter() {
    return writer;
  }

  public Board setWriter(Worker writer) {
    this.writer = writer;
    return this;
  }
  
  public int getStatus() {
    return status;
  }

  public Board setStatus(int status) {
    this.status = status;
    return this;
  }
}

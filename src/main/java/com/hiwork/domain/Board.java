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

  // 게시판
  /*
  public static final int NOTICE = 1;      // 공지사항
  public static final int NEWS = 2;        // 사내소식
  public static final int BB = 3;          // 사내게시판
  public static final int CAFETERIA = 4;   // 구내식단
*/
  // 게시글 정보
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="bno")
  private long no;
  
  @Column(name="ctno")
  private int categoryNo;
  private String title;
  
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

  public int getCategoryNo() {
    return categoryNo;
  }

  public Board setCategoryNo(int categoryNo) {
    this.categoryNo = categoryNo;
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
  /*
  public static int getNotice() {
    return NOTICE;
  }

  public static int getNews() {
    return NEWS;
  }

  public static int getBb() {
    return BB;
  }

  public static int getCafeteria() {
    return CAFETERIA;
  }
  */
}

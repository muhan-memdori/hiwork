package com.hiwork.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cms_category")
public class Category {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ctno")
  private int no;
  
  @Column(name="ctName")
  private String name;
  
  public int getNo() {
    return no;
  }
  public Category setNo(int no) {
    this.no = no;
    return this;
  }
  public String getName() {
    return name;
  }
  public Category setName(String name) {
    this.name = name;
    return this;
  }
}

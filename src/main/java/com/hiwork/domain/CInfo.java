package com.hiwork.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cms_cinfo")
public class CInfo {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="crno")
  private long no;

  @Column(name="cname")
  private String name;

  public long getNo() {
    return no;
  }

  public CInfo setNo(long no) {
    this.no = no;
    return this;
  }

  public String getName() {
    return name;
  }

  public CInfo setName(String name) {
    this.name = name;
    return this;
  }
}

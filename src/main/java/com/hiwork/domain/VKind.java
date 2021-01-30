package com.hiwork.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cms_cKind")
public class VKind {

  public static final int ALLDAY = 1; // 연차 휴가
  public static final int HALF_MORNING = 2; // 오전 반차
  public static final int HALF_AFTERNOON = 3; // 오후 반차

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="vCode")
  private String vacayCode;

  @Column(name="name")
  private String vacayName;

  public String getVacayCode() {
    return vacayCode;
  }

  public VKind setVacayCode(String vacayCode) {
    this.vacayCode = vacayCode;
    return this;
  }

  public String getVacayName() {
    return vacayName;
  }

  public VKind setVacayName(String vacayName) {
    this.vacayName = vacayName;
    return this;
  }

}

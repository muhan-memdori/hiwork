package com.hiwork.domain;

import java.sql.Date;
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
@Table(name="cms_vApp")
public class VApp {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="vNo")
  private long vacayNo;

  @JoinColumn(name="vCode")
  private String vacayCode;

  @ManyToOne(targetEntity=Worker.class, fetch=FetchType.LAZY)
  @JoinColumn(name="wNo")
  private Worker worker;

  @Column(name="adt")
  private Date appliedDate; // 신청일

  @Column(name="sdt")
  private Date startDate; // 휴가 시작일

  @Column(name="edt")
  private Date endDate; // 휴가 종료일

  @Column(name="used")
  private int usedVacation; // 사용된 연차 일수

  @Column(name="rs")
  private String reason; // 신청 사유

  @Column(name="appr")
  private Boolean isApproved; // 승인 여부

  public long getVacayNo() {
    return vacayNo;
  }

  public VApp setVacayNo(long vacayNo) {
    this.vacayNo = vacayNo;
    return this;
  }

  public String getVacayCode() {
    return vacayCode;
  }

  public VApp setVacayCode(String vacayCode) {
    this.vacayCode = vacayCode;
    return this;
  }

  public Worker getWorker() {
    return worker;
  }

  public VApp setWorker(Worker worker) {
    this.worker = worker;
    return this;
  }

  public Date getAppliedDate() {
    return appliedDate;
  }

  public VApp setAppliedDate(Date appliedDate) {
    this.appliedDate = appliedDate;
    return this;
  }

  public Date getStartDate() {
    return startDate;
  }

  public VApp setStartDate(Date startDate) {
    this.startDate = startDate;
    return this;
  }

  public Date getEndDate() {
    return endDate;
  }

  public VApp setEndDate(Date endDate) {
    this.endDate = endDate;
    return this;
  }

  public int getUsedVacation() {
    return usedVacation;
  }

  public VApp setUsedVacation(int usedVacation) {
    this.usedVacation = usedVacation;
    return this;
  }

  public String getReason() {
    return reason;
  }

  public VApp setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public Boolean getIsApproved() {
    return isApproved;
  }

  public VApp setIsApproved(Boolean isApproved) {
    this.isApproved = isApproved;
    return this;
  }

}

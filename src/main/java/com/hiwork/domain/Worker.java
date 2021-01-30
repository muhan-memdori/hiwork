package com.hiwork.domain;

import java.sql.Date;
import javax.persistence.*;

@Entity
public class Worker {
  
  public static final int ADMIN = 9; // 관리자
  public static final int STAFF = 0; // 사원
  public static final int HR= 1; // Human Resources 인사
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int no; // 사원 번호
  @Column(name="aCode")
  private int authority;
  @Column(name="gender")
  private int gender; // 성별
  @Column(name="wName")
  private String name; // 사원 이름
  @Column(name="email")
  private String email; // 사원 이메일
  @Column(name="pwd")
  private int password; // 비밀번호
  @Column(name="wPhoto")
  private String photo; // 사원 사진
  @Column(name="rank")
  private String rank; // 사원 직급
  @Column(name="tel")
  private int tel; // 휴대폰번호
  @Column(name="eType")
  private String employmentType; // 고용형태
  @Column(name="regiDate")
  private Date registrationDate; // 입사일
  @Column(name="tAnnu")
  private int totaAnnual; // 총 연차
  @Column(name="eSt")
  private int employmentState; // 재직상태
 
  public static int getAdmin() {
    return ADMIN;
  }
  public static int getStaff() {
    return STAFF;
  }
  public static int getHr() {
    return HR;
  }
  public int getAuthority() {
    return authority;
  }
  public Worker setAuthority(int authority) {
    this.authority = authority;
    return this;
  }
  public int getNo() {
    return no;
  }
  public Worker setNo(int no) {
    this.no = no;
    return this;
  }
  public int getGender() {
    return gender;
  }
  public Worker setGender(int gender) {
    this.gender = gender;
    return this;
  }
  public String getName() {
    return name;
  }
  public Worker setName(String name) {
    this.name = name;
    return this;
  }
  public String getEmail() {
    return email;
  }
  public Worker setEmail(String email) {
    this.email = email;
    return this;
  }
  public int getPassword() {
    return password;
  }
  public Worker setPassword(int password) {
    this.password = password;
    return this;
  }
  public String getPhoto() {
    return photo;
  }
  public Worker setPhoto(String photo) {
    this.photo = photo;
    return this;
  }
  public String getRank() {
    return rank;
  }
  public Worker setRank(String rank) {
    this.rank = rank;
    return this;
  }
  public int getTel() {
    return tel;
  }
  public Worker setTel(int tel) {
    this.tel = tel;
    return this;
  }
  public String getEmploymentType() {
    return employmentType;
  }
  public Worker setEmploymentType(String employmentType) {
    this.employmentType = employmentType;
    return this;
  }
  public Date getRegistrationDate() {
    return registrationDate;
  }
  public Worker setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
    return this;
  }
  public int getTotaAnnual() {
    return totaAnnual;
  }
  public Worker setTotaAnnual(int totaAnnual) {
    totaAnnual = totaAnnual;
    return this;
  }
  public int getEmploymentState() {
    return employmentState;
  }
  public Worker setEmploymentState(int employmentState) {
    this.employmentState = employmentState;
    return this;
  }
}

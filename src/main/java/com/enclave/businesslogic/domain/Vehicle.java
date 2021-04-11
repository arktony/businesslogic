package com.enclave.businesslogic.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Basic
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private java.util.Date arrDate;
    private String hsCode;
    private String irNo;
    private String keyNo;
    private String specCode;
    @NotBlank
    private String t1No;
    @NotBlank
    @Basic
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private java.util.Date t1Date;
    private String im7No;
    @Basic
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private java.util.Date im7Date;
    @NotBlank
    private String importer;
    @NotBlank
    private String clearAgent;
    @NotBlank
    private String bodyDesc;
    private String cc;
    @NotBlank
    private int year;
    @NotBlank
    private Double bif;
    @NotBlank
    private String chassisNo;
    @NotBlank
    private String make;
    private String remarks;
    private String status;
    @ManyToOne
    private User user;
    @ManyToOne
    private Business business;

    public Vehicle() {
    }

    public Vehicle(Long id, Date arrDate, String hsCode, String irNo, String keyNo, String specCode, @NotBlank String t1No, Date t1Date, String im7No, Date im7Date, @NotBlank String importer, @NotBlank String clearAgent, @NotBlank String bodyDesc, String cc, @NotBlank int year, @NotBlank Double bif, @NotBlank String chassisNo, @NotBlank String make, String remarks, String status, User user, Business business) {
        this.id = id;
        this.arrDate = arrDate;
        this.hsCode = hsCode;
        this.irNo = irNo;
        this.keyNo = keyNo;
        this.specCode = specCode;
        this.t1No = t1No;
        this.t1Date = t1Date;
        this.im7No = im7No;
        this.im7Date = im7Date;
        this.importer = importer;
        this.clearAgent = clearAgent;
        this.bodyDesc = bodyDesc;
        this.cc = cc;
        this.year = year;
        this.bif = bif;
        this.chassisNo = chassisNo;
        this.make = make;
        this.remarks = remarks;
        this.status = status;
        this.user = user;
        this.business = business;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getArrDate() {
        return arrDate;
    }

    public void setArrDate(Date arrDate) {
        this.arrDate = arrDate;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getIrNo() {
        return irNo;
    }

    public void setIrNo(String irNo) {
        this.irNo = irNo;
    }

    public String getKeyNo() {
        return keyNo;
    }

    public void setKeyNo(String keyNo) {
        this.keyNo = keyNo;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getT1No() {
        return t1No;
    }

    public void setT1No(String t1No) {
        this.t1No = t1No;
    }

    public Date getT1Date() {
        return t1Date;
    }

    public void setT1Date(Date t1Date) {
        this.t1Date = t1Date;
    }

    public String getIm7No() {
        return im7No;
    }

    public void setIm7No(String im7No) {
        this.im7No = im7No;
    }

    public Date getIm7Date() {
        return im7Date;
    }

    public void setIm7Date(Date im7Date) {
        this.im7Date = im7Date;
    }

    public String getImporter() {
        return importer;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    public String getClearAgent() {
        return clearAgent;
    }

    public void setClearAgent(String clearAgent) {
        this.clearAgent = clearAgent;
    }

    public String getBodyDesc() {
        return bodyDesc;
    }

    public void setBodyDesc(String bodyDesc) {
        this.bodyDesc = bodyDesc;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getBif() {
        return bif;
    }

    public void setBif(Double bif) {
        this.bif = bif;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}

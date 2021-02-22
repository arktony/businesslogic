package com.enclave.businesslogic.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate arrDate;
    private String hsCode;
    private String irNo;
    private String keyNo;
    private String specCode;
    private String t1No;
    private LocalDate t1Date;
    private String im7No;
    private LocalDate im7Date;
    private String importer;
    private String clearAgent;
    private String bodyDesc;
    private String cc;
    private int year;
    private Boolean bif;
    private String chassisNo;
    private String remarks;
    private String status;
    @ManyToOne
    private User user;
    @ManyToOne
    private Business business;

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getArrDate() {
        return arrDate;
    }

    public void setArrDate(LocalDate arrDate) {
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

    public LocalDate getT1Date() {
        return t1Date;
    }

    public void setT1Date(LocalDate t1Date) {
        this.t1Date = t1Date;
    }

    public String getIm7No() {
        return im7No;
    }

    public void setIm7No(String im7No) {
        this.im7No = im7No;
    }

    public LocalDate getIm7Date() {
        return im7Date;
    }

    public void setIm7Date(LocalDate im7Date) {
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

    public Boolean getBif() {
        return bif;
    }

    public void setBif(Boolean bif) {
        this.bif = bif;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", arrDate=" + arrDate +
                ", hsCode='" + hsCode + '\'' +
                ", irNo='" + irNo + '\'' +
                ", keyNo='" + keyNo + '\'' +
                ", specCode='" + specCode + '\'' +
                ", t1No='" + t1No + '\'' +
                ", t1Date=" + t1Date +
                ", im7No='" + im7No + '\'' +
                ", im7Date=" + im7Date +
                ", importer='" + importer + '\'' +
                ", clearAgent='" + clearAgent + '\'' +
                ", bodyDesc='" + bodyDesc + '\'' +
                ", cc='" + cc + '\'' +
                ", year=" + year +
                ", bif=" + bif +
                ", chassisNo='" + chassisNo + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", business=" + business +
                '}';
    }
}

package com.bgv.main.dto;

import java.util.Date;

public class RequestDTO {
    private String companyName1;

    private String doj1;

    private String lastwd1;

    private String address1;

    private String companyName2;

    private String doj2;

    private String lastwd2;

    private String address2;

    private String hdegree;

    private String college;

    private String passedOutYear;

    public RequestDTO(String companyName1, String doj1, String lastwd1, String address1, String companyName2, String doj2, String lastwd2, String address2, String hdegree, String college, String passedOutYear) {
        this.companyName1 = companyName1;
        this.doj1 = doj1;
        this.lastwd1 = lastwd1;
        this.address1 = address1;
        this.companyName2 = companyName2;
        this.doj2 = doj2;
        this.lastwd2 = lastwd2;
        this.address2 = address2;
        this.hdegree = hdegree;
        this.college = college;
        this.passedOutYear = passedOutYear;
    }

    public String getCompanyName1() {
        return companyName1;
    }

    public void setCompanyName1(String companyName1) {
        this.companyName1 = companyName1;
    }

    public String getDoj1() {
        return doj1;
    }

    public void setDoj1(String doj1) {
        this.doj1 = doj1;
    }

    public String getLastwd1() {
        return lastwd1;
    }

    public void setLastwd1(String lastwd1) {
        this.lastwd1 = lastwd1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCompanyName2() {
        return companyName2;
    }

    public void setCompanyName2(String companyName2) {
        this.companyName2 = companyName2;
    }

    public String getDoj2() {
        return doj2;
    }

    public void setDoj2(String doj2) {
        this.doj2 = doj2;
    }

    public String getLastwd2() {
        return lastwd2;
    }

    public void setLastwd2(String lastwd2) {
        this.lastwd2 = lastwd2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getHdegree() {
        return hdegree;
    }

    public void setHdegree(String hdegree) {
        this.hdegree = hdegree;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPassedOutYear() {
        return passedOutYear;
    }

    public void setPassedOutYear(String passedOutYear) {
        this.passedOutYear = passedOutYear;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "companyName1='" + companyName1 + '\'' +
                ", doj1=" + doj1 +
                ", lastwd1=" + lastwd1 +
                ", address1='" + address1 + '\'' +
                ", companyName2='" + companyName2 + '\'' +
                ", doj2=" + doj2 +
                ", lastwd2=" + lastwd2 +
                ", address2='" + address2 + '\'' +
                ", hdegree='" + hdegree + '\'' +
                ", college='" + college + '\'' +
                ", passedOutYear=" + passedOutYear +
                '}';
    }
}

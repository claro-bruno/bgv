package com.bgv.models;

import java.util.Date;

public class Request {
    private Integer id;

    private String employeeId;

    private Date submittedDate;

    private String status;

    private String employeeName;


    private String companyName1;

    private Date doj1;

    private Date lastwd1;

    private String address1;


    private String companyName2;

    private Date doj2;

    private Date lastwd2;

    private String address2;

    private String hdegree;

    private String college;

    private Integer passedOutYear;

    private String remarks;

    public Request() {}

    public Request(Integer id, String employeeId, String employeeName, Date submittedDate, String status, String remarks ) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.submittedDate = submittedDate;
        this.status = status;
        this.remarks = remarks;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;

        Request request = (Request) o;

        return getEmployeeId().equals(request.getEmployeeId());
    }

    public void setEmpresa1(String companyName1, Date doj1, Date lastwd1, String address1) {
        this.companyName1 = companyName1;
        this.doj1 = doj1;
        this.lastwd1 = lastwd1;
        this.address1 = address1;
    }

    public void setEmpresa2(String companyName2, Date doj2, Date lastwd2, String address2) {
        this.companyName2 = companyName2;
        this.doj2 = doj2;
        this.lastwd2 = lastwd2;
        this.address2 = address2;
    }

    public void setEducacional(String hdegree, String college, Integer passedOutYear) {
        this.hdegree = hdegree;
        this.college = college;
        this.passedOutYear = passedOutYear;
    }
    @Override
    public int hashCode() {
        return getEmployeeId().hashCode();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCompanyName1() {
        return companyName1;
    }

    public void setCompanyName1(String companyName1) {
        this.companyName1 = companyName1;
    }

    public Date getDoj1() {
        return doj1;
    }

    public void setDoj1(Date doj1) {
        this.doj1 = doj1;
    }

    public Date getLastwd1() {
        return lastwd1;
    }

    public void setLastwd1(Date lastwd1) {
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

    public Date getDoj2() {
        return doj2;
    }

    public void setDoj2(Date doj2) {
        this.doj2 = doj2;
    }

    public Date getLastwd2() {
        return lastwd2;
    }

    public void setLastwd2(Date lastwd2) {
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

    public Integer getPassedOutYear() {
        return passedOutYear;
    }

    public void setPassedOutYear(Integer passedOutYear) {
        this.passedOutYear = passedOutYear;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

package com.Bgv.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Request {
    private Integer id;
    private String employeeId;
    private Date submittedDate;
    private String status;
    private String employeeName;

    private String companyName1;
    private Date doj1;
    private Date lastwd1;
    private String adress1;

    private String companyName2;
    private Date doj2;
    private Date lastwd2;
    private String adress2;

    private String hdegree;
    private String college;
    private Integer passedOutYear;

    private String remarks;

//    private List<Company> companies = new ArrayList<>();
//    private Educational educational;

    public Request() {}

    public Request(Integer id, String employeeId, String employeeName, Date submittedDate, String status, String companyName1, Date doj1, Date lastwd1, String adress1, String companyName2, Date doj2, Date lastwd2, String adress2, String hdegree, String college, Integer passedOutYear) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.submittedDate = submittedDate;
        this.status = status;
        this.companyName1 = companyName1;
        this.doj1 = doj1;
        this.lastwd1 = lastwd1;
        this.adress1 = adress1;
        this.companyName2 = companyName2;
        this.doj2 = doj2;
        this.lastwd2 = lastwd2;
        this.adress2 = adress2;
        this.hdegree = hdegree;
        this.college = college;
        this.passedOutYear = passedOutYear;
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

//    public List<Company> getCompanies() {
//        return companies;
//    }
//
//    public void addCompany(Company company) {
//        companies.add(company);
//    }
//
//    public void removeCompany(Company company) {
//        companies.remove(company);
//    }
//
//    public Educational getEducational() {
//        return educational;
//    }
//
//    public void setEducational(Educational educational) {
//        this.educational = educational;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;

        Request request = (Request) o;

        return getEmployeeId().equals(request.getEmployeeId());
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

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
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

    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2;
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

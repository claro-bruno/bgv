package com.Bgv.request.services;

import com.Bgv.login.services.LoginService;
import com.Bgv.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RequestService {

    @Autowired
    LoginService service;

    private static List<Request> requests = new ArrayList<Request>();

    private static int requestsCount = 2;

    static {
        Request request1 = new Request(1, "123456", "Ram", new Date(),"Open",
                "IBM India", new Date(), new Date(),"No 123, Outer Ring road, Bangalore, India",
                "MBI India", new Date(), new Date(),"No 123, Outer Ring road, Bangalore, India",
                "Bachelor of Engineering", "VTU, Belgaum, Kamataka", 2014);


        Request request2 = new Request(2, "654321", "Sam", new Date(),"Open",
                "Wipro India", new Date(), new Date(),"No 123, Outer Ring road, Bangalore, India",
                "Orpiw India", new Date(), new Date(),"No 123, Outer Ring road, Bangalore, India",
                "Bachelor of Engineering", "VTU, Belgaum, Kamataka", 2014
                );
//        Company company1 = new Company("IBM India", new Date(), new Date(),"No 123, Outer Ring road, Bangalore, India");
//        Company company2 = new Company("MBI India", new Date(), new Date(),"No 123, Outer Ring road, Bangalore, India");
//        Company company3 = new Company("Wipro India", new Date(), new Date(),"No 123, Outer Ring road, Bangalore, India");
//        Company company4 = new Company("Orpiw India", new Date(), new Date(),"No 123, Outer Ring road, Bangalore, India");
//        Educational edu1 = new Educational("Bachelor of Engineering", 2014, "VTU, Belgaum, Kamataka");
//        Educational edu2 = new Educational("Bachelor of Engineering", 2014, "VTU, Belgaum, Kamataka");

//        request1.addCompany(company1);
//        request1.addCompany(company2);
//        request2.addCompany(company3);
//        request2.addCompany(company4);
//        request1.setEducational(edu1);
//        request2.setEducational(edu2);
//        request1.setEmployeeName("Ram");
//        request2.setEmployeeName("Sam");
        requests.add(request1);
        requests.add(request2);
    }

    public List<Request> retrieveAllRequests() {
        Comparator<Request> comparator = (h1, h2) -> h1.getId().compareTo(h2.getId());
        requests.sort(comparator.reversed());
        return requests;
    }

    public List<Request> retrieveRequests(String employeeId) {
        List<Request> filteredRequests = new ArrayList<Request>();
        for (Request request : requests) {
            if (request.getEmployeeId().equals(employeeId))
                filteredRequests.add(request);
        }
        Comparator<Request> comparator = (r1, r2) -> r1.getId().compareTo(r2.getId());
        requests.sort(comparator.reversed());
        return filteredRequests;
    }

    public Request retrieveRequest(Integer id) {
        List<Request> filteredRequests = new ArrayList<Request>();
        for (Request request : requests) {
            if (request.getId().equals(id))
                filteredRequests.add(request);
        }
        return filteredRequests.get(0);
    }

    public void addRequest(Request request, String name, String userId) {
        requests.add(new Request(++requestsCount, userId , name, new Date(), "Open",
                request.getCompanyName1(), request.getDoj1(), request.getLastwd1(), request.getAdress1(),
                request.getCompanyName2(), request.getDoj2(), request.getLastwd2(), request.getAdress2(),
                request.getHdegree(), request.getCollege(), request.getPassedOutYear()));
    }

    public void editRequest(Request last, Request request) {

        last.setCompanyName1(request.getCompanyName1());
        last.setDoj1(request.getDoj1());
        last.setLastwd1(request.getLastwd2());
        last.setAdress1(request.getAdress1());
        last.setCompanyName2(request.getCompanyName2());
        last.setDoj2(request.getDoj2());
        last.setLastwd2(request.getLastwd2());
        last.setAdress2(request.getAdress2());
        last.setHdegree(request.getHdegree());
        last.setCollege(request.getHdegree());
        last.setPassedOutYear(request.getPassedOutYear());

    }

    public void updateStatus(Request last, String status, String remarks) {

        last.setStatus(status);
        last.setRemarks(remarks);
    }


    public void deleteRequest(int id) {
        Iterator<Request> iterator = requests.iterator();
        while (iterator.hasNext()) {
            Request request = iterator.next();
            if (request.getId() == id) {
                iterator.remove();
            }
        }
    }

}

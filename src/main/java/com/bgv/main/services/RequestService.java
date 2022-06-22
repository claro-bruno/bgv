package com.bgv.main.services;

import com.bgv.main.dto.RequestDTO;
import com.bgv.main.dto.RequestUpdateDTO;
import com.bgv.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RequestService {

    @Autowired
    LoginService service;

    private static final List<Request> requests = new ArrayList<>();

    public List<Request> retrieveAllRequests() {
        Comparator<Request> comparator = (h1, h2) -> h1.getId().compareTo(h2.getId());
        requests.sort(comparator.reversed());
        return requests;
    }

    public List<Request> retrieveRequests(String employeeId) {
        List<Request> filteredRequests = new ArrayList<>();
        for (Request request : requests) {
            if (request.getEmployeeId().equals(employeeId))
                filteredRequests.add(request);
        }
        Comparator<Request> comparator = (r1, r2) -> r1.getId().compareTo(r2.getId());
        requests.sort(comparator.reversed());
        return filteredRequests;
    }

    public Request retrieveRequest(Integer id) {
        List<Request> filteredRequests = new ArrayList<>();
        for (Request request : requests) {
            if (request.getId().equals(id))
                filteredRequests.add(request);
        }
        return filteredRequests.get(0);
    }

    public void addRequest(RequestDTO request, String name, String userId) {

        try {
            Date doj1 = new SimpleDateFormat("dd-MM-yyyy").parse(request.getDoj1());
            Date doj2 = new SimpleDateFormat("dd-MM-yyyy").parse(request.getDoj2());
            Date lastwd1 = new SimpleDateFormat("dd-MM-yyyy").parse(request.getLastwd1());
            Date lastwd2 = new SimpleDateFormat("dd-MM-yyyy").parse(request.getLastwd1());
            Request req = new Request(requests.size() + 1, userId , name, new Date(), "Open", "");
            req.setEmpresa1(request.getCompanyName1(),  doj1, lastwd1, request.getAddress1());
            req.setEmpresa2(request.getCompanyName2(),  doj2, lastwd2,  request.getAddress2());
            req.setEducacional(request.getHdegree(), request.getCollege(), Integer.parseInt(request.getPassedOutYear()));
            requests.add(req);
        }
        catch (Exception e) {
            e.getMessage();
        }

    }

    public void editRequest(Request last, RequestUpdateDTO request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            last.setCompanyName1(request.getCompanyName1());
            last.setDoj1(dateFormat.parse(request.getDoj1()));
            last.setLastwd1(dateFormat.parse(request.getLastwd2()));
            last.setAddress1(request.getAddress1());
            last.setCompanyName2(request.getCompanyName2());
            last.setDoj2(dateFormat.parse(request.getDoj2()));
            last.setLastwd2(dateFormat.parse(request.getLastwd2()));
            last.setAddress2(request.getAddress2());
            last.setHdegree(request.getHdegree());
            last.setCollege(request.getHdegree());
            last.setPassedOutYear(Integer.parseInt(request.getPassedOutYear()));
        }
        catch (Exception e) {
            e.getMessage();
        }


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

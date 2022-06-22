package com.bgv.main;

import com.bgv.main.dto.RequestDTO;
import com.bgv.main.dto.RequestUpdateDTO;
import com.bgv.main.services.LoginService;
import com.bgv.models.Error;
import com.bgv.models.Login;
import com.bgv.main.services.RequestService;
import com.bgv.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@SessionAttributes({"userData", "error"})
public class MainController {

    static final String ERROR = "errorMsg";
    static final String ERR = "error";
    static final String LOGIN = "login";
    static final String USERDATA = "userData";


    static final String REDIRECT = "redirect:/login";
    static final String REDIRECTHOME = "redirect:/home";
    static final String REDIRECTADMIN = "redirect:adminhome";
    static final String USER = "userId";
    private static final String REQUESTS = "requests";
    private static final String REQUESTADMIN = "requestdAdmin";
    private static final String REQUEST = "request";

    @Autowired
    LoginService service;
    @Autowired
    RequestService serviceRequest;

    @GetMapping(value = "/")
    public String showMainPage(ModelMap model){
        return REDIRECT;
    }

    @GetMapping(value = "/login")
    public String showLoginPage(ModelMap model, @RequestParam(required = false) String errorMsg){
        model.put(ERROR, errorMsg);
        return LOGIN;
    }

    @PostMapping(value = "/login")
    public String handleLoginRequest(ModelMap modelMap, @RequestParam String userName, @RequestParam String password){

        Login result = service.retrieveLogin(userName, password);
        if (result == null) {
            modelMap.addAttribute(ERROR, "Invalid Credentials");
            return LOGIN;
        }
        else if(Objects.equals(result.getRole(), "user")){

            modelMap.put(USERDATA, result);
            return REDIRECTHOME;
        }
        else {
            modelMap.put(USERDATA, result);
            return REDIRECTADMIN;
        }


    }

    @RequestMapping(value = "/logout")
    public String logout(ModelMap model) {
        model.clear();
        return REDIRECT;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }



    @GetMapping(value = "/home")
    public String showTodosList(ModelMap model) {
        Error error = new Error("");
        model.put(ERR, error);
        Login login = (Login) model.get(USERDATA);

        model.put(REQUESTS, serviceRequest.retrieveRequests(login.getUserId()));
        model.put("name", login.getName());

        List<Request> requests = serviceRequest.retrieveRequests(login.getUserId());
        if(requests.isEmpty()) {
            error = new Error("No requests to display");
            model.put(ERR, error);
        }
        return "home";
    }

    @GetMapping(value = "/adminhome")
    public String showAllTodosList(ModelMap model) {
        Login login = (Login) model.get(USERDATA);
        model.put(REQUESTS, serviceRequest.retrieveAllRequests());
        model.put("name", login.getName());
        List <Request> requests = serviceRequest.retrieveAllRequests();
        if(requests.isEmpty()) {
            Error error = new Error("No requests to display");
            model.put(ERR, error);
        }
        return "adminhome";
    }

    @GetMapping(value = "/createRequest")
    public String showCreateRequest(ModelMap model) {
        Login login = (Login) model.get(USERDATA);
        Error error = new Error("");
        model.put(ERR, error);
        model.put("name", login.getName());

        return REQUEST;
    }

    @PostMapping(value = "/createRequest")
    public String addRequest(ModelMap model, RequestDTO req) {
        Login login = (Login) model.get(USERDATA);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {

            Date doj1 = dateFormat.parse(req.getDoj1());
            Date doj2 = dateFormat.parse(req.getDoj2());
            Date lastwd1 = dateFormat.parse(req.getLastwd1());
            Date lastwd2 = dateFormat.parse(req.getLastwd2());
            int year = req.getPassedOutYear().length();
            if (Objects.equals(req.getCompanyName1(), "")
                    || (Objects.equals(req.getAddress1(), ""))
                    || (Objects.equals(req.getCompanyName2(), ""))
                    || (Objects.equals(req.getAddress2(), ""))
                    || (Objects.equals(req.getHdegree(), ""))
                    || (Objects.equals(req.getCollege(), ""))
                    || (Objects.equals(req.getPassedOutYear().toString(), ""))
                    || year == 0 || year > 4
            )
            {
                Error error = new Error("Invalid Input Data");
                model.put(ERR, error);
            }
            else {
                Error error = new Error("Created the request successfully");
                model.put(ERR, error);
            }

        }
        catch(Exception e) {
            Error error = new Error("Invalid Input Data");
            model.put(ERR, error);
        }


        serviceRequest.addRequest(req, login.getName(), login.getUserId());
        model.put(REQUESTS, serviceRequest.retrieveRequests(login.getUserId()));
        model.put("name", login.getName());

        return REQUEST;
    }

    @GetMapping(value = "/editrequest")
    public String showUpdateRequest(ModelMap model, @RequestParam int id) {
        Error error = new Error("");
        model.put(ERR, error);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        Login login = (Login) model.get(USERDATA);
        Request req = serviceRequest.retrieveRequest(id);
        RequestUpdateDTO reqDTO = new RequestUpdateDTO();
        reqDTO.setId(id);
        reqDTO.setCompanyName1(req.getCompanyName1());
        reqDTO.setCompanyName2(req.getCompanyName2());
        reqDTO.setDoj1(formatter.format(req.getDoj1()));
        reqDTO.setDoj2(formatter.format(req.getDoj2()));
        reqDTO.setLastwd1(formatter.format(req.getLastwd1()));
        reqDTO.setLastwd2(formatter.format(req.getLastwd2()));
        reqDTO.setAddress1(req.getAddress1());
        reqDTO.setAddress2(req.getAddress1());
        reqDTO.setHdegree(req.getHdegree());
        reqDTO.setCollege(req.getCollege());
        reqDTO.setPassedOutYear(req.getPassedOutYear().toString());
        reqDTO.setEmployeeId(req.getEmployeeId());

        model.addAttribute(REQUEST, reqDTO);
        model.put("name", login.getName());
        return "updaterequest";
    }

    @PostMapping(value = "/editrequest")
    public String updateRequest(ModelMap model, RequestUpdateDTO req) {
        Login login = (Login) model.get(USERDATA);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {

            Date doj1 = dateFormat.parse(req.getDoj1());
            Date doj2 = dateFormat.parse(req.getDoj2());
            Date lastwd1 = dateFormat.parse(req.getLastwd1());
            Date lastwd2 = dateFormat.parse(req.getLastwd2());
            int year = req.getPassedOutYear().length();
            if (Objects.equals(req.getCompanyName1(), "")
                    || (Objects.equals(req.getAddress1(), ""))
                    || (Objects.equals(req.getCompanyName2(), ""))
                    || (Objects.equals(req.getAddress2(), ""))
                    || (Objects.equals(req.getHdegree(), ""))
                    || (Objects.equals(req.getCollege(), ""))
                    || (Objects.equals(req.getPassedOutYear().toString(), ""))
                    || year == 0 || year > 4
            )
            {
                Error error = new Error("Invalid Input Data");
                model.put(ERR, error);
            }
            else {
                Error error = new Error("Updated the request successfully");
                model.put(ERR, error);
            }

        }
        catch(Exception e) {
            Error error = new Error("Invalid Input Data");
            model.put(ERR, error);
        }


        Request last = serviceRequest.retrieveRequest(req.getId());
        serviceRequest.editRequest(last, req);
        model.put(REQUESTS, serviceRequest.retrieveRequests(req.getEmployeeId()));
        model.put("name", login.getName());
        return "updaterequest";
    }

    @GetMapping(value = "/updateStatus")

    public String showUpdateStatus(ModelMap model, @RequestParam int id) {
        Login login = (Login) model.get(USERDATA);
        model.addAttribute(REQUEST, serviceRequest.retrieveRequest(id));
        model.put("name", login.getName());
        return "requestAdmin";
    }

    @PostMapping(value = "/updateStatus")
    public String updateStatus(ModelMap model, Request request, @RequestParam String status, @RequestParam String remarks) {
        if (Objects.equals(status, "")
                || (Objects.equals(remarks, ""))
        )
        {
            Error error = new Error("Invalid Input Data");
            model.put(ERR, error);
        }
        Request last = serviceRequest.retrieveRequest(request.getId());
        serviceRequest.updateStatus(last, status, remarks);
        model.clear();
        model.put(REQUESTS, serviceRequest.retrieveAllRequests());
        return "requestAdmin";
    }

}

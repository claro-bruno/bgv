package com.Bgv.request;

import com.Bgv.models.Request;
import com.Bgv.request.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes({"userId","name"})
public class RequestController
{
    @Autowired
    private RequestService service;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/createRequest", method = RequestMethod.GET)
    public String showCreateRequest(ModelMap model) {
        model.addAttribute("request", new Request());
        model.addAttribute("title", "Create Request");
        return "request";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showTodosList(ModelMap model) {
        model.addAttribute("requests", service.retrieveRequests((String)model.get("userId")));
        return "home";
    }

    @RequestMapping(value = "/adminhome", method = RequestMethod.GET)
    public String showAllTodosList(ModelMap model) {
        model.addAttribute("requests", service.retrieveAllRequests());
        return "adminhome";
    }

    @RequestMapping(value = "/createRequest", method = RequestMethod.POST)
    public String addRequest(ModelMap model, Request request,  BindingResult result) {
        service.addRequest(request, (String) model.get("name"), (String) model.get("userId"));

        // model.clear();// to prevent request parameter "name" to be passed
        model.addAttribute("requests", service.retrieveRequests((String)model.get("userId")));
        model.addAttribute("errorMessage", "Request Created Successfully");
        return "home";
    }

    @RequestMapping(value = "/editRequest", method = RequestMethod.GET)
    public String showUpdateRequest(ModelMap model, @RequestParam int id) {
        model.addAttribute("request", service.retrieveRequest(id));
        model.addAttribute("title", "Edit Request");
        return "request";
    }

    @RequestMapping(value = "/editRequest", method = RequestMethod.POST)
    public String updateRequest(ModelMap model, Request request,  BindingResult result) {
        Request last = service.retrieveRequest(request.getId());
        service.editRequest(last, request);
         //model.clear();// to prevent request parameter "name" to be passed
        model.put("requests", service.retrieveRequests((String)model.get("userId")));
        model.put("errorMessage", "Request Edited Successfully");
        return "home";
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
    public String showUpdateStatus(ModelMap model, @RequestParam int id) {
        model.addAttribute("request", service.retrieveRequest(id));
        return "requestAdmin";
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public String updateStatus(ModelMap model, Request request,  BindingResult result, @RequestParam String status, @RequestParam String remarks) {
        Request last = service.retrieveRequest(request.getId());
        service.updateStatus(last, status, remarks);
         model.clear();// to prevent request parameter "name" to be passed
        model.put("errorMessage", "Status Updated Successfully");
        model.addAttribute("requests", service.retrieveAllRequests());
        return "adminhome";
    }

}

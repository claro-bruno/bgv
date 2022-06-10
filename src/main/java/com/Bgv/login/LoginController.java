package com.Bgv.login;

import com.Bgv.login.services.LoginService;
import com.Bgv.models.Login;
import com.Bgv.request.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Objects;

@Controller
@SessionAttributes({"userId","name"})
public class LoginController {

    @Autowired
    LoginService service;

    @Autowired
    RequestService serviceRequest;

    @RequestMapping(value = "/")
    public String showLoginPage(ModelMap model){
        model.put("loginPage", "Ok");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLoginRequest(ModelMap modelMap, @RequestParam String userName, @RequestParam String password){

        Login result = service.retrieveLogin(userName, password);
        if (result == null) {
            modelMap.put("errorMessage", "Invalid Credentials");
            // modelMap.addAttribute("errorMessage", "Invalid Credentials!!");
            return "login";
        }
        else if(Objects.equals(result.getRole(), "user")){
            modelMap.addAttribute("name", result.getName());
            modelMap.addAttribute("userId", result.getUserId());

            modelMap.addAttribute("requests",
                    serviceRequest.retrieveRequests(result.getUserId()));
            return "home";
        }
        else {
            modelMap.addAttribute("name", result.getName());
            modelMap.addAttribute("userId", result.getUserId());
            modelMap.addAttribute("requests", serviceRequest.retrieveAllRequests());
            return "adminhome";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        model.put("errorMessage", "Returned to login");
        return "login";
    }



}

package com.Bgv.login.services;

import org.springframework.stereotype.Service;
import com.Bgv.models.Login;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LoginService {

    private static List<Login> logins = new ArrayList<Login>();


    static {
        logins.add(new Login("Ram", "123456", "wipro@123","user"));
        logins.add(new Login("Sam", "654321", "wipro@123","user"));
        logins.add(new Login("Admin", "admin", "admin@123","admin"));
    }

    public Login retrieveLogin(String userId, String password) {
        for (Login login : logins) {
            if (Objects.equals(login.getUserId(), userId) && Objects.equals(login.getPassword(), password))
                return login;
        }
        return null;
    }

    public Login retrieveName(String userId) {
        for (Login login : logins) {
            if (Objects.equals(login.getUserId(), userId))
                return login;
        }
        return null;
    }

}

/**
 * <!--
 * <input size="50" placeholder="Title: Numb Cover" name="title" id="title" type="text" required maxlength="50"  pattern="[a-zA-Z0-9._\s]+" title="This field can contain only alpha numeric characters..">
 * --!>
 * */
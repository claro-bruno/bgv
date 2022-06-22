package com.bgv.models;

public class Login {
    private String name;
    private String userId;
    private String password;
    private String role;

    public Login() {}

    public Login(String name, String userId, String password, String role) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getUserId() {
        return userId;
    }

    public void setId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;

        Login login = (Login) o;

        if (!getUserId().equals(login.getUserId())) return false;
        return getPassword().equals(login.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getUserId().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}

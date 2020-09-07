package com.clariontechnologies.model;

public class LoginDetail {
    private String username;
    private String password;
    private boolean isValid;

    public LoginDetail(String username, String password, boolean isValid) {
        this.username = username;
        this.password = password;
        this.isValid = isValid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
}

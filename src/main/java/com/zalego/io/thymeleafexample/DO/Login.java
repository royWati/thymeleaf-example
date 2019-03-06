package com.zalego.io.thymeleafexample.DO;

public class Login {

    private String username;
    private String pass;

    public Login(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

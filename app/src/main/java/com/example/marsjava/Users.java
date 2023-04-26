package com.example.marsjava;

public class Users {

    String name,code,pass;

    public Users() {
    }

    public Users(String name, String code, String pass) {
        this.name = name;
        this.code = code;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

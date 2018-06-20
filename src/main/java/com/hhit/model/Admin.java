package com.hhit.model;

import java.io.Serializable;

public class Admin implements Serializable {
    private String userid;
    private String password;
    private String username;
    public Admin(){
        super();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
}

package com.flipkart.bean;

public class Admin {
    private int adminId;
    private String name;

    int getAdminId(){
        return adminId;
    }

    String getname(){
        return name;
    }

    void setName(String n){
        name = n;
    }

    void setAdminId(int id){
        adminId = id;
    }
}

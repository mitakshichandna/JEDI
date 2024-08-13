package com.flipkart.bean;

public class User {
    private int userId;
    private String name;
    private String role;

    public User(String iD, String name2, String string, String contact, String email, String password) {
        //TODO Auto-generated constructor stub
    }

    public boolean updateDetails(User user) {
        return true;
    }

    public boolean updatePassword(User user) {
        return true;
    }

    public void setPassword(String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPassword'");
    }

    public Object getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    public Object getRole() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRole'");
    }

    public Object getID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getID'");
    }
}
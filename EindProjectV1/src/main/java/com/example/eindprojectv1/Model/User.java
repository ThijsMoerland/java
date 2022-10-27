package com.example.eindprojectv1.Model;

public class User {

    private int identifier;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    //constructor
    public User(int code,String firstname, String lastName, String username, String password) {
        this.identifier = code;
        this.firstname = firstname;
        this.lastname = lastName;
        this.username = username;
        this.password = password;
    }

    //getters
    public int getIdentifier() {
        return identifier;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    //setters

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
}

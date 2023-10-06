package com.example.helloworld;

public class User {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    private String lastName;
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public User(){
        firstName = "";
        lastName = "";
    }
}

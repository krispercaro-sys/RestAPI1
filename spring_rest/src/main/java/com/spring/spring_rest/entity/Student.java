package com.spring.spring_rest.entity;

public class Student {

    private String firstname;
    private String lastname;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstname = firstName;
        this.lastname = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
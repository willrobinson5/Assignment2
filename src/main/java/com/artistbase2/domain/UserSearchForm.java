package com.artistbase2.domain;

/**
 * Created by web on 26/04/17.
 */
public class UserSearchForm {
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    String firstname;
    String surname;
}


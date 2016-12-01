package com.semihbeceren.Model;

import javax.persistence.Entity;

/**
 * Created by Semih Beceren on 11/22/2016.
 */
@Entity
public class Account extends NamedEntity{

    public Account() {
    }


    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.name = "Genel";
    }

    public Account(String name, String username, String password) {
        this.username = username;
        this.password = password;
        this.name = name;
    }



    private String username, password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username + " : " + password;
    }
}

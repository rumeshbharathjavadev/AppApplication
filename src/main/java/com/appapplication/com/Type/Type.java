package com.appapplication.com.Type;

import com.appapplication.com.Application.Application;
import com.appapplication.com.UserApplication.UserApplication;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;



@JsonIgnore
    @ManyToOne
    private UserApplication userApplication;




    public Type() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public UserApplication getUserApplication() {
        return userApplication;
    }

    public void setUserApplication(UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    public void setType(String type) {
        this.type = type;
    }



}

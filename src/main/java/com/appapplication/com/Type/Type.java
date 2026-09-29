package com.appapplication.com.Type;

import com.appapplication.com.UserApplication.UserApplication;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Type {

    @Id
    private Long id;
    private String type;




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

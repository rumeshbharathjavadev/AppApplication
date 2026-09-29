package com.appapplication.com.Category;

import com.appapplication.com.UserApplication.UserApplication;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {

    @Id
    private Long id;
    private String category;


    @ManyToOne
    private UserApplication userApplication;

    public Long getId() {
        return id;
    }


    public Category() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UserApplication getUserApplication() {
        return userApplication;
    }

    public void setUserApplication(UserApplication userApplication) {
        this.userApplication = userApplication;
    }
}

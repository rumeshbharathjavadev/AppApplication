package com.appapplication.com.Category;

import com.appapplication.com.User.UserApplication;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {

    @Id
    private Long id;
    private String category;

    @ManyToOne
    private UserApplication user;

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

    public UserApplication getUser() {
        return user;
    }

    public void setUser(UserApplication user) {
        this.user = user;
    }
}

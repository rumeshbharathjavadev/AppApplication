package com.appapplication.com.Application;

import com.appapplication.com.Access.Access;
import com.appapplication.com.Review.Review;
import com.appapplication.com.User.UserApplication;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appname;
    private Integer appversion;
    private String appstoage;
    private Float appbatterycapacity;


    @OneToMany(mappedBy = "application")
    private List<UserApplication> user;

    @OneToMany(mappedBy = "application")
    private List<Access> access;

    @OneToMany(mappedBy = "application")
    private List<Review> review;

    public Application() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public Integer getAppversion() {
        return appversion;
    }

    public void setAppversion(Integer appversion) {
        this.appversion = appversion;
    }

    public String getAppstoage() {
        return appstoage;
    }

    public void setAppstoage(String appstoage) {
        this.appstoage = appstoage;
    }

    public Float getAppbatterycapacity() {
        return appbatterycapacity;
    }

    public void setAppbatterycapacity(Float appbatterycapacity) {
        this.appbatterycapacity = appbatterycapacity;
    }

    public List<UserApplication> getUser() {
        return user;
    }

    public void setUser(List<UserApplication> user) {
        this.user = user;
    }

    public List<Access> getAccess() {
        return access;
    }

    public void setAccess(List<Access> access) {
        this.access = access;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}

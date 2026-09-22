package com.appapplication.com.User;

import com.appapplication.com.Category.Category;
import com.appapplication.com.Type.Type;
import com.appapplication.com.Details.Details;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String gender;
    private String age;

    @OneToMany(mappedBy = "user")
    private List<Type> acctountype;

    @OneToMany(mappedBy = "user")
    private List<Category> accountcategory;

    @ManyToOne
    private Details application;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Type> getAcctountype() {
        return acctountype;
    }

    public void setAcctountype(List<Type> acctountype) {
        this.acctountype = acctountype;
    }

    public List<Category> getAccountcategory() {
        return accountcategory;
    }

    public void setAccountcategory(List<Category> accountcategory) {
        this.accountcategory = accountcategory;
    }

    public Details getApplication() {
        return application;
    }

    public void setApplication(Details application) {
        this.application = application;
    }
}

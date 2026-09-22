package com.appapplication.com.User.impl;

import com.appapplication.com.Application.Application;
import com.appapplication.com.Application.ApplicationRepository;
import com.appapplication.com.Application.ApplicationSevice;
import com.appapplication.com.User.UserApplication;
import com.appapplication.com.User.UserRepository;
import com.appapplication.com.User.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ApplicationSevice applicationSevice;

    public UserServiceImpl(UserRepository userRepository, ApplicationSevice applicationSevice) {
        this.userRepository = userRepository;
        this.applicationSevice = applicationSevice;
    }


    @Override
    public boolean addUser(Long applicationId,UserApplication userApplication) {
        Application application=applicationSevice.getApplication(applicationId);
        if(application!=null){
            userRepository.save(userApplication);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<UserApplication> getAllUser() {
        return userRepository.findAll();
    }
}

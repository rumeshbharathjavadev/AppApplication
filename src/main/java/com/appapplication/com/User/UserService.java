package com.appapplication.com.User;

import org.apache.catalina.User;

import java.util.List;

public interface UserService {


    boolean addUser(Long applicationId,UserApplication userApplication);

    List<UserApplication> getAllUser();
}

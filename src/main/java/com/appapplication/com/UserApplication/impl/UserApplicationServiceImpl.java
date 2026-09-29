package com.appapplication.com.UserApplication.impl;

import com.appapplication.com.Application.Application;
import com.appapplication.com.Application.ApplicationSevice;
import com.appapplication.com.UserApplication.UserApplication;
import com.appapplication.com.UserApplication.UserApplicationRepository;

import com.appapplication.com.UserApplication.UserApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private UserApplicationRepository  userApplicationRepository;
    private ApplicationSevice applicationSevice;

    public UserApplicationServiceImpl(UserApplicationRepository userApplicationRepository, ApplicationSevice applicationSevice) {
        this.userApplicationRepository = userApplicationRepository;
        this.applicationSevice = applicationSevice;
    }


    @Override
    public boolean addUser(Long applicationId,UserApplication userApplication) {
        Application application=applicationSevice.getApplication(applicationId);
        if(application!=null){
            userApplication.setApplication(application);
            userApplicationRepository.save(userApplication);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<UserApplication> getAllUser() {
        return userApplicationRepository.findAll();
    }

    @Override
    public UserApplication getUserId(Long applicationId, Long userApplicationId) {
        List<UserApplication> userApplications =userApplicationRepository.findByApplicationId(applicationId);
        if (!userApplications.isEmpty()){
            return userApplications.stream().filter(userApplication -> userApplication.getId().equals(userApplicationId)).findFirst().orElse(null);

        }
   return  null;
    }

    @Override
    public boolean updateUser(Long applicationId, Long userApplicationId , UserApplication userApplication ) {

        Application application=applicationSevice.getApplication(applicationId);
        if(application!=null){
            userApplication.setId(userApplicationId);
            userApplication.setUsername(userApplication.getUsername());
            userApplication.setGender(userApplication.getGender());
            userApplication.setAge(userApplication.getAge());
            userApplication.setApplication(application);
            userApplicationRepository.save(userApplication);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long userApplicationId) {
        Application application = applicationSevice.getApplication(userApplicationId);
     //  UserApplication userApplication= userApplicationRepository.findById(userApplicationId).orElse(null);
        if (application != null ) {

           // Application removeapplication=userApplication.getApplication();
          //  removeapplication.getUserApplications().remove(userApplication);
         //   userApplication.setApplication(null);
            userApplicationRepository.deleteById(userApplicationId);
            return true;
        }
        else{
            return false;
        }
    }
}

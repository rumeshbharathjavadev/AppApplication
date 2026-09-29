package com.appapplication.com.Type.impl;

import com.appapplication.com.Application.ApplicationSevice;
import com.appapplication.com.Type.Type;
import com.appapplication.com.Type.TypeRepository;
import com.appapplication.com.Type.TypeService;
import com.appapplication.com.UserApplication.UserApplication;
import com.appapplication.com.UserApplication.UserApplicationService;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {


private UserApplicationService userApplicationService;
private TypeRepository typeRepository;


    public TypeServiceImpl(UserApplicationService userApplicationService, TypeRepository typeRepository) {
        this.userApplicationService = userApplicationService;
        this.typeRepository = typeRepository;
    }

    @Override
    public boolean addType(Long applicationId, Long userApplicationId, Type type) {


        UserApplication userApplication=userApplicationService.getUserId(applicationId,userApplicationId);


       if (userApplication!=null) {
          // type.setUserApplication(userApplication);
           typeRepository.save(type);
           return true;
       }else{

           return false;
       }
    }
}

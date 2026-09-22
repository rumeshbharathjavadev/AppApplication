package com.appapplication.com.Application.impl;

import com.appapplication.com.Application.Application;
import com.appapplication.com.Application.ApplicationRepository;
import com.appapplication.com.Application.ApplicationSevice;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationSevice {

    private ApplicationRepository applicationRepository;


    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }
}

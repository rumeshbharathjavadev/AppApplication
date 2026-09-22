package com.appapplication.com.Application.impl;

import com.appapplication.com.Application.Application;
import com.appapplication.com.Application.ApplicationRepository;
import com.appapplication.com.Application.ApplicationSevice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getApplication(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateApplication(Long id, Application application) {
        Application updateApplication = getApplication(id);
        if (updateApplication != null) {
            updateApplication.setAppname(application.getAppname());
            updateApplication.setAppversion(application.getAppversion());
            updateApplication.setAppstoage(application.getAppstoage());
            updateApplication.setAppbatterycapacity(application.getAppbatterycapacity());
            updateApplication.setUser(application.getUser());
            updateApplication.setAccess(application.getAccess());
            updateApplication.setReview(application.getReview());
            applicationRepository.save(updateApplication);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteApplication(Long id) {
        Application updateApplication = getApplication(id);
        if (updateApplication != null) {
            applicationRepository.deleteById(id);
            return true;
        }else  {
            return false;
        }
    }
}

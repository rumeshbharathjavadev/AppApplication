package com.appapplication.com.Application;

import java.util.List;

public interface ApplicationSevice {

    Application addApplication(Application application);

    List<Application> getAllApplication();

    Application getApplication(Long id);

    boolean updateApplication(Long id,Application application);

    boolean deleteApplication(Long id);
}

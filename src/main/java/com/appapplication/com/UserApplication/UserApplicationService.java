package com.appapplication.com.UserApplication;

import java.util.List;

public interface UserApplicationService {


    boolean addUser(Long applicationId,UserApplication userApplication);

    List<UserApplication> getAllUser();

    UserApplication getUserId(Long applicationId,Long userApplicationId);

    boolean updateUser(Long userApplicationId, Long applicationId, UserApplication userApplication );

    boolean deleteUser(Long userApplicationId);
}

package com.appapplication.com.UserApplication;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserApplicationRepository extends JpaRepository<UserApplication,Long> {

    List<UserApplication> findByApplicationId(Long applicationId);
}

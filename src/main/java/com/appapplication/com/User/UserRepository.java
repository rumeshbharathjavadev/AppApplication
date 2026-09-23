package com.appapplication.com.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserApplication,Long> {

    List<UserApplication> findByApplicationId(Long applicationId);
}

package com.appapplication.com.Access;

import com.appapplication.com.Application.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access,Long> {
}

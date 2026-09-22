package com.appapplication.com.Type;

import com.appapplication.com.Review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Review,Long> {
}

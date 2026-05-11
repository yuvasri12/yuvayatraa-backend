package com.yuvayatraa.backend.repository;

import com.yuvayatraa.backend.entity.LoginActivity;
import com.yuvayatraa.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoginActivityRepository extends JpaRepository<LoginActivity, Long> {
    List<LoginActivity> findByUserOrderByLoginTimeDesc(User user);
}
package com.user.service.service;


import com.user.service.response.UserRegistrationBean;
import com.user.service.response.UserResponseBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponseBean getUserByEmail(String toString);

    UserResponseBean getUserById(Long userId);

    UserResponseBean register(UserRegistrationBean userRegistrationBean);

    List<UserResponseBean> getAllUser();
}
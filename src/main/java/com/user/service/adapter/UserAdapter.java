package com.user.service.adapter;

import com.user.service.model.UserEntity;
import com.user.service.response.UserRegistrationBean;
import com.user.service.response.UserResponseBean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserAdapter {
    public UserResponseBean adapt(UserEntity userEntity){
        return UserResponseBean.builder().userId(userEntity.getId())
                .fullName(userEntity.getFullName()).email(userEntity.getEmail())
                .state(userEntity.getState()).password(userEntity.getPassword())
                .build();
    }

    public UserEntity adapt(UserRegistrationBean request){
        return UserEntity.builder()
                .fullName(request.getFullName()).email(request.getEmail())
                .state("ACTIVE").password(request.getPassword())
                .build();
    }

    public List<UserResponseBean> adapt(List<UserEntity> allUsers){
        return Optional.ofNullable(allUsers).orElseGet(Collections::emptyList)
                .stream().map(input-> adapt(input))
                .collect(Collectors.toList());

    }
}

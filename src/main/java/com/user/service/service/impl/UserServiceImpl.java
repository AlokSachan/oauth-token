package com.user.service.service.impl;


import com.user.service.adapter.UserAdapter;
import com.user.service.model.UserEntity;
import com.user.service.repository.UserRepository;
import com.user.service.response.UserRegistrationBean;
import com.user.service.response.UserResponseBean;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserAdapter userAdapter;


	@Override
	public UserResponseBean getUserByEmail(String email) {
		UserEntity userEntity = Optional.ofNullable(userRepository.findByEmail(email))
				.orElseThrow(() -> new UsernameNotFoundException(email));
		return userAdapter.adapt(userEntity);
	}

	@Override
	public UserResponseBean getUserById(Long userId) {
		Optional<UserEntity> userEntity = Optional.ofNullable(userRepository.findById(userId))
				.orElseThrow(()-> new UsernameNotFoundException(userId.toString()));
		return userAdapter.adapt(userEntity.get());
	}

	@Override
	public UserResponseBean register(UserRegistrationBean userRegistrationBean) {
		UserEntity userEntity = userAdapter.adapt(userRegistrationBean);
		UserEntity savedUserEntity = userRepository.save(userEntity);
		return userAdapter.adapt(savedUserEntity);
	}

	@Override
	public List<UserResponseBean> getAllUser() {
		return userAdapter.adapt(userRepository.findAll());
	}
}

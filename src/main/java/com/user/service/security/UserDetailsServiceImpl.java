package com.user.service.security;

import com.user.service.model.UserEntity;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmailAndState(username, "ACTIVE");
        if(Objects.nonNull(userEntity)){
            User userDetails = new User(userEntity.getEmail(), userEntity.getPassword()
                    ,true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("USER")));
            return  userDetails;
        }
        else {
            throw new UsernameNotFoundException("Username not found");
        }

    }
}

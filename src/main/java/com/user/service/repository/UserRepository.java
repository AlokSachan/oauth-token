package com.user.service.repository;

import com.user.service.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


    UserEntity findByEmailAndState(String username, String active);

    UserEntity findByEmail(String email);

    Optional<UserEntity> findById(Long userId);
}

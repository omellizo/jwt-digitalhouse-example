package com.digitalhouse.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalhouse.jwt.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUsername(String username);

}

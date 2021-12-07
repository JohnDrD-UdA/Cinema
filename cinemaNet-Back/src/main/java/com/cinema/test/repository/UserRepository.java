package com.cinema.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.test.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

	UserModel findByUserName(String userName);
}

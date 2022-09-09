package com.user.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.api.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}

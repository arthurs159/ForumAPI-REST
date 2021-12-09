package com.ForumApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ForumApi.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

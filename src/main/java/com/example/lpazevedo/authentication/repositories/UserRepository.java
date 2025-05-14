package com.example.lpazevedo.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.lpazevedo.authentication.model.user.User;


public interface UserRepository extends JpaRepository<User, String>{
  UserDetails findByLogin(String login);
}

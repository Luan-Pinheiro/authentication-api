package com.example.lpazevedo.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lpazevedo.authentication.model.user.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, String>{
  List<User> findByLogin(String login);
}

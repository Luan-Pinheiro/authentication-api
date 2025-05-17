package com.example.lpazevedo.authentication.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lpazevedo.authentication.dto.UserResponseDTO;
import com.example.lpazevedo.authentication.model.user.User;

@Service
public class AuthenticationService {
  @Autowired
  UserRepository userRepository;

  public boolean verifyIfUserExists(String login){
    return (userRepository.findByLogin(login) != null);
  }

  public User registerNewUser(UserResponseDTO data){ 
    String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
    User newUser = new User(data.login(),encryptedPassword, data.role());
    return this.userRepository.save(newUser);
  }

  public List<UserResponseDTO> listUsers(){
    return this.userRepository.findAll().stream().map(UserResponseDTO::new).toList();
  }
}

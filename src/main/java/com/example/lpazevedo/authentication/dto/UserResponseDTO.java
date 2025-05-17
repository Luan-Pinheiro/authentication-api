package com.example.lpazevedo.authentication.dto;


import com.example.lpazevedo.authentication.model.user.User;
import com.example.lpazevedo.authentication.model.user.UserRole;
import jakarta.validation.constraints.NotBlank;

public record UserResponseDTO(@NotBlank String login,@NotBlank String password,UserRole role) {
    public UserResponseDTO(User user){
        this(user.getLogin(), user.getPassword(), user.getRole());
    }
}


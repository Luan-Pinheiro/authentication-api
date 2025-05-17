package com.example.lpazevedo.authentication.controllers;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.example.lpazevedo.authentication.model.user.User;
import org.springframework.web.bind.annotation.RestController;
import com.example.lpazevedo.authentication.dto.LoginResponseDTO;
import com.example.lpazevedo.authentication.dto.UserResponseDTO;
import com.example.lpazevedo.authentication.model.user.AuthenticationDTO;
import com.example.lpazevedo.authentication.repositories.AuthenticationService;
import com.example.lpazevedo.authentication.service.TokenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private AuthenticationService authenticationService;
  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
    var usernamePassword = new UsernamePasswordAuthenticationToken (data.login(), data.password());
    var auth =  this.authenticationManager.authenticate(usernamePassword);

    var token = tokenService.generateToken((User) auth.getPrincipal());

    return ResponseEntity.ok(new LoginResponseDTO(token));
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody @Valid UserResponseDTO data) {
    if(authenticationService.verifyIfUserExists(data.login()))
      return ResponseEntity.badRequest().build();
    
      authenticationService.registerNewUser(data);
    return ResponseEntity.ok().build();
  }
  
}

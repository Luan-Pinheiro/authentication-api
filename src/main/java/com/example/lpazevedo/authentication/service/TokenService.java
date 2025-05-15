package com.example.lpazevedo.authentication.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.lpazevedo.authentication.model.user.User;

@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(User user){
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token = JWT.create()
                     .withIssuer("authentication-api")
                     .withSubject(user.getLogin())
                     .withExpiresAt(generationExpirationDate())
                     .sign(algorithm);
      return token;
    } catch (JWTCreationException e) {
      throw new RuntimeException("Error while generating token");
    }
  }



  public String validadeToken(String token){
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
             .withIssuer("authentication-api")
             .build()
             .verify(token)
             .getSubject();
      
    } catch (JWTVerificationException e) {
      return "";
    }
  }

  private Instant generationExpirationDate(){
    //Tempo de expiracao de 2 horas a partir da chamada (definida no horario de brasilia)
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}

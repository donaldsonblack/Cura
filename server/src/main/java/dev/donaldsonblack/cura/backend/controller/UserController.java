package dev.donaldsonblack.cura.backend.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/me")
  public String getUser(@AuthenticationPrincipal Jwt jwt) {
    // @TODO - Implement logic to retrieve user information from the JWT token
    jwt.getClaims().forEach((key, value) -> {
      System.out.println(key + ": " + value);
    });
    return jwt.getClaimAsString("username");
  }

  @GetMapping("/jwt")
  public String getJwtClaims(@AuthenticationPrincipal Jwt jwt) {
    // Return the JWT claims as a string
    return jwt.getClaims().toString();
  }
}
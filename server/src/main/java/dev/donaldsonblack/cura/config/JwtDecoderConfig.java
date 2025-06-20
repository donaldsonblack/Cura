package dev.donaldsonblack.cura.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Configuration
public class JwtDecoderConfig {

  @Value("${issuer-uri}")
  private String issuerUri;

  @Bean
  public JwtDecoder jwtDecoder() {
    // Create a JwtDecoder bean that uses the issuer URI from application properties
    return NimbusJwtDecoder
        .withJwkSetUri(issuerUri)
        .build();
  }
}

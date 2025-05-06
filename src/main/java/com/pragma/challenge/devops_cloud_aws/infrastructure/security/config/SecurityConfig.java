package com.pragma.challenge.devops_cloud_aws.infrastructure.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Slf4j
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

  @Value("${spring.security.oauth2.client.resourceserver.jwt.jwk-set-uri}")
  private String jwkSetUri;

  @Value("${spring.security.oauth2.client.provider.cognito.issuer-uri}")
  private String issuerUri;

  // TODO find a way to build authorities
  @Bean
  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http.authorizeExchange(
            exchanges ->
                exchanges
                    .pathMatchers("/actuator/health")
                    .permitAll()
                    .anyExchange()
                    .authenticated())
        .oauth2Login(Customizer.withDefaults())
        .oauth2ResourceServer(
            oauth2 ->
                oauth2.jwt(
                    jwt ->
                        jwt.jwkSetUri(jwkSetUri)
                            .jwtDecoder(
                                token -> ReactiveJwtDecoders.fromOidcIssuerLocation(issuerUri))))
        .build();
  }
}

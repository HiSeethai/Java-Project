package com.example.demo.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
Exception {
http
.csrf(csrf -> csrf.disable()) // Disable CSRF for testing
.authorizeHttpRequests(auth -> auth
.requestMatchers("/", "/index", "/css/**").permitAll() // Allow public access
.anyRequest().authenticated() // Secure other pages
);
return http.build();
}
}
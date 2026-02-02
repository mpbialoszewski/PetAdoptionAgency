package com.mpb.petadoptionagency.config;

import com.mpb.petadoptionagency.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import java.util.Optional;


@Configuration
@EnableWebSecurity
public class AppConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Only for H2/Testing
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("Admin") // Looks for ROLE_Admin
                        .requestMatchers("/user/**").hasAnyRole("User", "Admin")
                        .requestMatchers("/h2-console/**").permitAll() // Allow DB access
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .headers(headers -> headers.frameOptions(f -> f.disable())); // Needed for H2 Console

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Not found"));
            }
        };
    }
}


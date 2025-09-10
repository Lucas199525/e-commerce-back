package com.ArcomTech.ApiV1.security;

import com.ArcomTech.ApiV1.exceptions.NotFoundException;
import com.ArcomTech.ApiV1.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserRepository repository;

    public SecurityConfig(UserRepository repository) {
        this.repository = repository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Rutas públicas
                        .anyRequest().authenticated() // Todas las demás requieren autenticación
                )
                .formLogin(form -> form.disable()) // Desactiva el formulario de login por defecto
                .httpBasic(basic -> basic.init(http)); // Habilita autenticación básica

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        return username -> {
            final com.ArcomTech.ApiV1.model.User user = repository.findOneByMail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getMail())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        };


    }
}


package com.imc.imc_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/registro", "/login","/index").permitAll() // Permitir acceso sin autenticación a registro y login
                    .anyRequest().authenticated() // Requerir autenticación para cualquier otra ruta
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login") // Configurar página personalizada de login
                    .defaultSuccessUrl("/calculo", true) // Redirigir a /calculo tras login exitoso
                    .permitAll() // Permitir acceso a la página de login sin autenticación
            )
            .logout(logout ->
                logout
                    .logoutSuccessUrl("/login?logout") // Redirigir a login después de logout
                    .permitAll() // Permitir acceso a logout sin autenticación
            );

        return http.build();
    }

    @Bean
    public Argon2PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder(16, 32, 1, 65536, 20);
    }
}

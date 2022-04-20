package com.integratec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// https://www.youtube.com/watch?v=her_7pa0vrg 50:39

@Configuration
public class PasswordConfig {

    // BCrypt is said to be the most popular password encoder, hence its use
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}

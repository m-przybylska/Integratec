package com.integratec.config;

import com.integratec.controllers.AccountController;
import com.integratec.model.repositories.AccountRepository;
import com.integratec.model.repositories.RequestRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AccountConfig {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, RequestRepository requestRepository,
            AccountController controller) {
        return args -> {};

    }
}

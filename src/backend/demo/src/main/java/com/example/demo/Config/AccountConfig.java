package com.example.demo.Config;

import java.util.List;

import com.example.demo.domain.Account;
import com.example.demo.repositories.AccountRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AccountConfig {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository )
    {
        return args -> {
            Account account1 = new Account(
                "login1",
                "password1"
            );

            Account account2 = new Account(
                "login2",
                "password2"
            );

            Account account3 = new Account(
                "login3",
                "password3"
            );
            repository.saveAll(
                List.of(account1,account2,account3)
            );

        };
    }
}

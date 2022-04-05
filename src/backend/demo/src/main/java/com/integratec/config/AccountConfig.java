package com.integratec.config;
import java.util.List;

import com.integratec.controllers.AccountController;
import com.integratec.model.domain.Account;
import com.integratec.model.domain.Request;
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
        return args -> {
            Account account1 = new Account(
                    "login1",
                    "password1");

            Account account2 = new Account(
                    "login2",
                    "password2");

            Account account3 = new Account(
                    "login3",
                    "password3");
            accountRepository.saveAll(
                    List.of(account1, account2));
                    controller.postAccount(account3);
            Request request = new Request(
                    1L,
                    2L,
                    3L,
                    "title",
                    "text",
                    "comment");
            requestRepository.save(request);
        };

    }
}

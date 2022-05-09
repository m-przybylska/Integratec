package com.integratec.config;

import com.integratec.controllers.AccountController;
import com.integratec.controllers.RequestController;
import com.integratec.model.domain.Account;
import com.integratec.model.repositories.AccountRepository;
import com.integratec.model.repositories.RequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, RequestRepository requestRepository,
                                        AccountController controller, RequestController requestController) throws Exception {
        return args -> {
            Account account = new Account(1L, "login1", "pass", "agata", "kowalska");
            accountRepository.save(account);
        };

    }
}

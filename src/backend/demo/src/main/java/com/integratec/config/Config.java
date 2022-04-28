package com.integratec.config;

import com.integratec.controllers.AccountController;
import com.integratec.controllers.RequestController;
import com.integratec.model.domain.Account;
import com.integratec.model.domain.Request;
import com.integratec.model.domain.RequestCategory;
import com.integratec.model.repositories.AccountRepository;
import com.integratec.model.repositories.RequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

@Configuration
@EnableSwagger2
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, RequestRepository requestRepository,
                                        AccountController controller, RequestController requestController) throws Exception {
        RequestCategory requestCategory = new RequestCategory(1L, "kitchen");
        return args -> {
            //Request request2 = new Request(10L, 5L, 6L, "testowy request", "test", "works",new Date(), requestCategory,null, null);
            //requestController.postRequests(request2);
            //Account account = new Account(1L, "login1", "pass");
           // accountRepository.save(account);
        };

    }
}

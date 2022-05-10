package com.integratec.config;

import com.integratec.controllers.AccountController;
import com.integratec.controllers.RequestController;
import com.integratec.model.domain.Account;
import com.integratec.model.domain.DTO.RequestPostDTO;
import com.integratec.model.domain.Request;
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
        return args -> {
            Account account = new Account(1L, "login1", "pass", "agata", "kowalska");
            accountRepository.save(account);
            RequestPostDTO requestPostDTO = new RequestPostDTO(1L, 3L, 3L, "cofj", "lfjsla", "jlfs",new Date(2000,11,11), 1L, 1L, null);
            requestController.postRequest(requestPostDTO);
        };

    }
}

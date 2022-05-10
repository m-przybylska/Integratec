package com.integratec.model.domain.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountPostDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("user_account_id")
    private Long accountId;


    @Size(min = 4, max = 30)
    @JsonProperty("login")
    private String login;

    @Size(min = 4, max = 30)
    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

}

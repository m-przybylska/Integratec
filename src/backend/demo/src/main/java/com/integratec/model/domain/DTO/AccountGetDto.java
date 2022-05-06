package com.integratec.model.domain.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
    @Data
    @Getter
    @Setter
    public class AccountGetDto {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonProperty("user_account_id")
        private Long accountId;

        @JsonProperty("name")
        private String name;

        @JsonProperty("surname")
        private String surname;
    }


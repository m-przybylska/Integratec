package com.integratec.model.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;     // we don't set this one manually in post, it's just generated

    @NotNull(message = "Login cannot be null")
    @Size(min = 4, message = "Login should be at least 4 characters long")  //TODO random value, prolly some regex
    @Column(name = "login")
    private String login;

    @NotNull(message = "Password cannot be null")  //TODO prolly some regex to match too
    @Column(name = "password")
    private String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
     }
}

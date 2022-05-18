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
    @Column(name = "user_account_id")
    private Long accountId;

    @NotNull(message = "Login cannot be null")
    @Size(min = 4, message = "Login should be at least 4 characters long")  //TODO random value, prolly some regex
    @Column(name = "login")
    private String login;

    @NotNull(message = "Password cannot be null")  //TODO prolly some regex to match too
    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

}
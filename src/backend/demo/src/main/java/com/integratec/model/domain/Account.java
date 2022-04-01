package com.integratec.model.domain;


import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long AccountId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public Account(String login3, String password3) { //tutaj mam problem, bo na mnie krzyczy ze chce taki kontruktor
    }
}

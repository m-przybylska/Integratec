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
            name = "accountSequence",
            sequenceName = "accountSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accountSequence"
    )
    private Long AccountId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
     }
}

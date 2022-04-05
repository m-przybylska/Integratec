package com.integratec.model.domain;


import lombok.*;

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
    private Long accountId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
     }
}

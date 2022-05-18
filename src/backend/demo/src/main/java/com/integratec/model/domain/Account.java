package com.integratec.model.domain;

import java.util.Collection;
import java.util.List;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Account implements UserDetails {

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

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public void setUsername(String login) {
        this.login = login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
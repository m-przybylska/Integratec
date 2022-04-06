package com.integratec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/*what a demonstrative SpringSecurity class might look like,
requires adding a mapping in the controller */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder user = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(user.username("login1").password("password1").roles("ADMIN"))
                .withUser(user.username("login2").password("password2").roles("ADMIN"))
                .withUser(user.username("login3").password("password3").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .formLogin().loginPage("login/login-page")
                .loginProcessingUrl("/authenticateUser")
                .defaultSuccessUrl("/requests")
                .and()
                .logout()
                .logoutSuccessUrl("login/login-page").permitAll();
    }
}

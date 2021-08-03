package org.moren.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/error/**", "**/static/**").permitAll()
                    .antMatchers("/login", "/registration").anonymous()
                    .mvcMatchers("/admin/**", "/actuator/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/")
                .and()
                    .logout().permitAll()
                .and()
                    .rememberMe();
    }
}
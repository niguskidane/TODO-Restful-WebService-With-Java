package com.todo.restfulwebservice.basicauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("nigus")
                .password("nigus")
                .roles("ADMIN")
                .and()
                .withUser("test")
                .password("test")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/basicauth").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.GET, "users/{username}/todos").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.GET, "users/{username}/todos/{id}").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.POST, "/users/{username}/todos").hasAnyRole("USER", "ADMIN")
//               .antMatchers(HttpMethod.OPTIONS,"/**").hasRole("ADMIN")
//                //.anyRequest().authenticated()
//                .and()
//                //.formLogin().and()
//                .httpBasic();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

                 http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated()
                .and()
                //.formLogin().and()
                .httpBasic();
    }
}


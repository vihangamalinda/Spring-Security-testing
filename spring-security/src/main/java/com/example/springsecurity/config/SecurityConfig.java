package com.example.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize ->{
                    // Below  commented code is about URL matching with permitAll
                    //authorize.antMatchers("/","/webjars/**","/login").permitAll();


                    authorize
                            // Below code represent  Http method matching
                            .antMatchers(HttpMethod.GET,"/partner/**").permitAll()

                        //Here we are using MvcMatcher not the antMathers as the wild card
                         // MvcMatchers helps to grab out the parameter from path variable
                            .mvcMatchers(HttpMethod.GET,"/partner/id/{id}").permitAll();

                })
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
    }
}

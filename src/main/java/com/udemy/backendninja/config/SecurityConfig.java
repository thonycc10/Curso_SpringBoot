package com.udemy.backendninja.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userService")
    private UserDetailsService userDetailsService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override      // alt + insert
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()                       // para las importaiones estaticas
            .antMatchers("/css/", "/imgs/").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
            .usernameParameter("username").passwordParameter("password")
            .defaultSuccessUrl("/loginsuccess").permitAll()
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import com.tienda.service.PersonaService;
import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author rivil
 */
@Configuration // entiende que lo que se hace aca es meramente configuracion
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { //setea la config de sec basada en Spring framework

    @Autowired //inyectamos dependencia
    private UserService userDetailsService; // el que acabamos de hacer con UserService y UserPrincipal... encripta contrasenas usando BCrypt algorithm

    //BCrypt algorithm para encryptar contrasenas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { // DECIMOS TIPO DE METODO DE ENCRIPCION
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService getUserService() {
        return new UserService();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() { //crea un objeto tipo DaoAuthenticationProvider, 
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()); //se puede setear el tipo de encoder (bcrypt)
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();

    }

    public SecurityConfig(UserService userPrincipalDetailsService) { // constructor como tal
        this.userDetailsService = userPrincipalDetailsService;
    }

    
    //El siguiente metodo funciona para ahcer la autenticacion del persona
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    protected void configure(HttpSecurity http) throws Exception { //
        http.authorizeRequests()
                .antMatchers("/persona", "/login", "/personasN") // PARA PROYECTO: aca se definen a que endpoints si tiene acceso esa persona
                .hasRole("ADMIN")
                .antMatchers("/persona", "/", "/login")
                .hasAnyRole("USER", "VENDEDOR", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/persona", true);

    }

    
    
    
    
}

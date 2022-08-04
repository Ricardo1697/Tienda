/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author rivil
 */
public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
 
    // maneja excepciones y cuando la auth ha sido exitosa
    protected void handle(HttpServletRequest request, HttpServletRequest response,
            Authentication authentication) throws IOException, ServletException {
    }
    
}

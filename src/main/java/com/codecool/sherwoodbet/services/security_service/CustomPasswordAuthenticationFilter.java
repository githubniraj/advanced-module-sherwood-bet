package com.codecool.sherwoodbet.services.security_service;

import com.codecool.sherwoodbet.model.Login;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by csyk on 2017.02.20..
 */
// TODO: 2017.02.24. should add SimpleGrantedAuthority user's role as a parameter outside from this class

public class CustomPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler =
            new MySimpleUrlAuthenticationSuccessHandler();


    public CustomPasswordAuthenticationFilter(){
        setAuthenticationSuccessHandler(mySimpleUrlAuthenticationSuccessHandler);
        setAuthenticationFailureHandler(myFailureHandler());
    }

    public SimpleUrlAuthenticationFailureHandler myFailureHandler() {
        return new MySimpleUrlAuthenticationFailureHandler();
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            BufferedReader reader = request.getReader();
            String line;
            line = reader.readLine();

            ObjectMapper mapper = new ObjectMapper();
            Login user = mapper.readValue(line, Login.class);

            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            logger.info("token is authenticated: " + token.isAuthenticated());
            return token;

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
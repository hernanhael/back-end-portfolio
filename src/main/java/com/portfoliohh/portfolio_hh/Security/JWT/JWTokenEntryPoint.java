package com.portfoliohh.portfolio_hh.Security.JWT;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JWTokenEntryPoint implements AuthenticationEntryPoint{
    private final static Logger logger = LoggerFactory.getLogger(JWTokenEntryPoint.class); 

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("The commence method fail");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
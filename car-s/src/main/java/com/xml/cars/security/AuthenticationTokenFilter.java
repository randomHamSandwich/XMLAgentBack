package com.xml.cars.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	System.out.println("Ad service AuthetificationTokenFilter doFilter ");
    	

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String role = httpRequest.getHeader("role");
        String username = httpRequest.getHeader("username");
        System.out.println("role:_" + role);
        System.out.println("username:_" + username);
        
        
        if (role != null) {
            Set<SimpleGrantedAuthority> authorities = new HashSet<>();

//            String[] tokens = role.split("\\|");
//            for (String token : tokens) {
//                authorities.add(new SimpleGrantedAuthority(token));
//            }
            authorities.add(new SimpleGrantedAuthority(role));

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, authorities);
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(request, response);
    }
}

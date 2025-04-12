package com.lfgn.auth_node.security;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, javax.servlet.http.HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Claims claims = jwtUtil.resolveClaims(request);
        if (claims != null) {
            // Proceed with valid JWT claims
            // You can pass the claims to the request, or set a security context here
        }
        filterChain.doFilter(request, response);
    }
}

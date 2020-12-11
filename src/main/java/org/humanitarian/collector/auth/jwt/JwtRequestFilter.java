package org.humanitarian.collector.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtRequestFilter extends OncePerRequestFilter {

    private static final String AUTH_PREFIX = "Bearer ";

    private UserDetailsService userDetailsService;

    private String jwtSecret;

    public JwtRequestFilter(UserDetailsService userDetailsService, String jwtSecret) {
        this.userDetailsService = userDetailsService;
        this.jwtSecret = jwtSecret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String headerAuthorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (headerAuthorization == null || headerAuthorization.isEmpty() || !headerAuthorization.startsWith(AUTH_PREFIX)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String token = headerAuthorization.split(" ")[1].strip();

        Date currDate = new Date();
        Claims claims = null;

        try {
            claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8))).build().parseClaimsJws(token).getBody();
        } catch (Exception ex) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        if (claims == null || currDate.after(claims.getExpiration())) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getAudience());

        if (userDetails == null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

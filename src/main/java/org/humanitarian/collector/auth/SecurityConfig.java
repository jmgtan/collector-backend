package org.humanitarian.collector.auth;

import org.humanitarian.collector.auth.jwt.JwtRequestFilter;
import org.humanitarian.collector.auth.models.Role;
import org.humanitarian.collector.auth.services.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthUserDetailsService userDetailsService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/collector/**").permitAll()
            .antMatchers("/auth/login").permitAll()
            .antMatchers("/auth/register").hasRole(Role.ROLE_ADMIN)
            .antMatchers("/dashboard/**").hasRole(Role.ROLE_ANALYST)
            .antMatchers("/data/**").hasRole(Role.ROLE_COLLECTOR)
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(
                    jwtRequestFilter(),
                    UsernamePasswordAuthenticationFilter.class
            )
            .exceptionHandling()
            .authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
                httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
                httpServletResponse.setContentType("application/json");
                httpServletResponse.getWriter().write("{\"statusCode\": 403, \"message\": \"You do not have access to the resource.\"}");
                httpServletResponse.getWriter().flush();
                httpServletResponse.getWriter().close();
            })
        ;
    }

    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter(userDetailsService, jwtSecret);
    }
}

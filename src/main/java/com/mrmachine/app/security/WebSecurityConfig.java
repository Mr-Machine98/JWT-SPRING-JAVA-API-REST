package com.mrmachine.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

	private final UserDetailsService usrDetailsService;
	private final JWTAuthorizationFilter jwtAuthorizationFilter;


    WebSecurityConfig( UserDetailsService usrDetailsService, JWTAuthorizationFilter jwtAuthorizationFilter) {
        this.usrDetailsService = usrDetailsService;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		
		var jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		return http
				.csrf()
				.disable()
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
//				.httpBasic()
//				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
//	@Bean
//	UserDetailsService userDetailsService() {
//		var manager = new InMemoryUserDetailsManager();
//		manager.createUser(
//				User
//					.withUsername("admin")
//					.password(passwordEncoder().encode("admin"))
//					.roles()
//					.build()
//		);
//		return manager;
//	}
	
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		return http
				.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(usrDetailsService)
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public static void main(String[] args) {
		System.out.println("pass: " + new BCryptPasswordEncoder().encode("1234"));
	}
}

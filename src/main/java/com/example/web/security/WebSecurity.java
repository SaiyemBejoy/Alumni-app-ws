package com.example.web.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.web.service.AlumniService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final AlumniService alumniDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(AlumniService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.alumniDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
				.permitAll().anyRequest().authenticated().and()
				.addFilter(getAuthenticationFielter())
				.addFilter(new AuthorizationFilter(authenticationManager()))
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(alumniDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	public AuthenticationFielter getAuthenticationFielter() throws Exception{
		final AuthenticationFielter filter = new AuthenticationFielter(authenticationManager());
		filter.setFilterProcessesUrl("/alumnus/login");
		return filter;
	}

}

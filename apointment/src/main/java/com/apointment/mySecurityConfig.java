package com.apointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apointment.config.JwtAuthenticationFilter;
import com.apointment.service.CustomUserDetailsService;



@Configuration
@EnableWebSecurity
public class mySecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired(required=true)
	private JwtAuthenticationEntryPoint unauthorizeHandler;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
//	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf()
		.disable()
		.cors()
		.disable()
		.authorizeHttpRequests()
		.antMatchers(HttpMethod.POST, "/token").permitAll()
		.regexMatchers("/token").permitAll()
		.regexMatchers("/welcome/id").permitAll()
		.regexMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(unauthorizeHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}
	

}

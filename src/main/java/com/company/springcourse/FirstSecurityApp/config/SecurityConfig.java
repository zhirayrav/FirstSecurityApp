package com.company.springcourse.FirstSecurityApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.company.springcourse.FirstSecurityApp.services.PersonDetailsService;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	private final PersonDetailsService personDetailsService;
	@Autowired
	public SecurityConfig(PersonDetailsService personDetailsService) {
		super();
		this.personDetailsService = personDetailsService;
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(personDetailsService).passwordEncoder(getPasswordEncoder());
//	}
	
	@Bean        //without  WebSecurityConfigurerAdapter,its deprecated 
	public AuthenticationManager authenticationManager(HttpSecurity http,BCryptPasswordEncoder bCrypt
					,UserDetailsService userDetail) throws Exception{
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(personDetailsService).passwordEncoder(getPasswordEncoder()).and()
				.build();
	}
	
	@Bean      //without  WebSecurityConfigurerAdapter,its deprecated and with lambda
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()                                  
//		.antMatchers("/auth/login","/auth/registration","/error").permitAll()
//		.anyRequest().hasAnyRole("USER","ADMIN")                                 //or hasAnyAuthority(ROLE_..)
//		.and()
//		.formLogin().loginPage("/auth/login").loginProcessingUrl("/process_login")
//		.defaultSuccessUrl("/hello", true).failureUrl("/auth/login?error")
//		.and()
//		.logout().logoutUrl("/logout").logoutSuccessUrl("/auth/login");
		http.authorizeHttpRequests((auth)-> auth.antMatchers("/auth/login","/auth/regisrtation","/error")
				.permitAll().anyRequest().hasAnyRole("USER","ADMIN"))
				.formLogin(fl->fl.loginPage("/auth/login").loginProcessingUrl("/process_login")
				.defaultSuccessUrl("/hello").failureUrl("/auth/login?error"))
				.logout(log->log.logoutUrl("/logout").logoutSuccessUrl("/auth/login"));
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return  new BCryptPasswordEncoder();
	}



}

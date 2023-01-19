package com.company.springcourse.FirstSecurityApp.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.company.springcourse.FirstSecurityApp.services.PersonDetailsService;

@Component
public class AuthProviderImpl implements AuthenticationProvider{
	private final PersonDetailsService personDetailsService;
	
	@Autowired
	public AuthProviderImpl(PersonDetailsService personDetailsService) {
		super();
		this.personDetailsService = personDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		UserDetails personDetails = personDetailsService.loadUserByUsername(username);
		String password = authentication.getCredentials().toString();
		if(password.equals(personDetails.getPassword()))
			return new UsernamePasswordAuthenticationToken(personDetails, password, Collections.emptyList());
		else
			throw new BadCredentialsException("Incorrect password!");
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}

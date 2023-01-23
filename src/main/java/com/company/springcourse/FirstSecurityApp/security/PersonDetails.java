package com.company.springcourse.FirstSecurityApp.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.company.springcourse.FirstSecurityApp.models.Person;

public class PersonDetails implements UserDetails{

	private final Person person;
	@Autowired
	public PersonDetails(Person person) {
		super();
		this.person = person;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.person.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.person.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Person getPerson() {
		return person;
	}
	
}

package com.company.springcourse.FirstSecurityApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.springcourse.FirstSecurityApp.models.Person;
import com.company.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import com.company.springcourse.FirstSecurityApp.security.PersonDetails;

@Service
public class PersonDetailsService implements UserDetailsService{
	private final PeopleRepository peopleRepository;
	
	@Autowired
	public PersonDetailsService(PeopleRepository peopleRepository) {
		super();
		this.peopleRepository = peopleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Person> person = peopleRepository.findByUsername(username);
		if(person.isEmpty())
			throw new UsernameNotFoundException("User not found!");
		else 
			return new PersonDetails(person.get());
	}

}

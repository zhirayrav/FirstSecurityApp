package com.company.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.springcourse.FirstSecurityApp.models.Person;
import com.company.springcourse.FirstSecurityApp.repositories.PeopleRepository;

@Service
public class PersonRegisterService {
	private final PeopleRepository peopleRepository;
	private final PasswordEncoder passwordEncoder;
	@Autowired
	public PersonRegisterService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
		super();
		this.peopleRepository = peopleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public void register(Person person) {
		person.setPassword(passwordEncoder.encode(person.getPassword()));
		person.setRole("ROLE_USER");
		peopleRepository.save(person);
	}
	
}

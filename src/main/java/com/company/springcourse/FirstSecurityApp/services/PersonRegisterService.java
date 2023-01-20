package com.company.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.springcourse.FirstSecurityApp.models.Person;
import com.company.springcourse.FirstSecurityApp.repositories.PeopleRepository;

@Service
public class PersonRegisterService {
	private final PeopleRepository peopleRepository;
	@Autowired
	public PersonRegisterService(PeopleRepository peopleRepository) {
		super();
		this.peopleRepository = peopleRepository;
	}
	@Transactional
	public void register(Person person) {
		peopleRepository.save(person);
	}
	
}

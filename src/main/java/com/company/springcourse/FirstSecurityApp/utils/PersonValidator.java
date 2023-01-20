package com.company.springcourse.FirstSecurityApp.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.company.springcourse.FirstSecurityApp.models.Person;
import com.company.springcourse.FirstSecurityApp.services.PersonDetailsService;

@Component
public class PersonValidator implements Validator{
	private final PersonDetailsService personDetailsService;
	@Autowired
	public PersonValidator(PersonDetailsService personDetailsService) {
		super();
		this.personDetailsService = personDetailsService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		try {
		personDetailsService.loadUserByUsername(person.getUsername());
		}catch(UsernameNotFoundException e) {
			return;
		}
		errors.rejectValue("username","","Человек с таким именем уже существует");
	}

	

}

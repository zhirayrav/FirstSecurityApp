package com.company.springcourse.FirstSecurityApp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.springcourse.FirstSecurityApp.models.Person;
import com.company.springcourse.FirstSecurityApp.services.PersonRegisterService;
import com.company.springcourse.FirstSecurityApp.utils.PersonValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {
	private final PersonValidator personValidator;
	private final PersonRegisterService personRegisterService;
	@Autowired
	public AuthController(PersonValidator personValidator, PersonRegisterService personRegisterService) {
		super();
		this.personValidator = personValidator;
		this.personRegisterService = personRegisterService;
	}
	@GetMapping("/login")
	public String loginPage() {
		return "auth/login";
	}
	@GetMapping("/registration")
	public String registrationPage(@ModelAttribute("person") Person person) {
		return "auth/registration";
	}
	@PostMapping("/registration")
	public String performRegistration(@ModelAttribute("person") @Valid Person person,BindingResult br) {
		personValidator.validate(person, br);
		if(br.hasErrors())
			return "/auth/registration";
		personRegisterService.register(person);
		return "redirect:/auth/login";
	}

}

package com.company.springcourse.FirstSecurityApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.company.springcourse.FirstSecurityApp.security.PersonDetails;

@Controller
public class HelloController {
	@GetMapping("hello")
	public String sayHello() {
		return "hello";
	}
	@GetMapping("showUserInfo")
	public String showUserInfo() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		PersonDetails personDetails = (PersonDetails) auth.getPrincipal();
		System.out.println(personDetails.getPerson());
		return "hello";
	}
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}

}

package com.company.springcourse.FirstSecurityApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.springcourse.FirstSecurityApp.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>{
	Optional<Person>  findByUsername(String username);

}

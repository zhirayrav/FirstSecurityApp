package com.company.springcourse.FirstSecurityApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	@NotEmpty(message = "Имя не должно быть пустым")
	@Size(max = 100,min = 2,message = "Размер должен быть в диопозоне 2-100 символов")
	private String username;
	@Column
	@Min(value = 1900,message = "Год рождения должен быть больше чем 1900")
	private int year_of_birth;
	@Column
	private String password;
	@Column
	private String role;
	
	public Person() {}
	public Person(
			@NotEmpty(message = "Имя не должно быть пустым") @Size(max = 100, min = 2, message = "Размер должен быть в диопозоне 2-100 символов") String username,
			@Min(value = 1900, message = "Год рождения должен быть больше чем 1900") int year_of_birth) {
		super();
		this.username = username;
		this.year_of_birth = year_of_birth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getYear_of_birth() {
		return year_of_birth;
	}
	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", year_of_birth=" + year_of_birth + ", password="
				+ password + "]";
	}
	
	
	
	
	
	
}

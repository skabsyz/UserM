package com.example.UserM.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name = "User")//it will create table with name User in db
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;

	private String name;
	private String password;

	private String email;

	private String city;

	private String mobile;
	// @CreationTimestamp
	//@Version
	// @Type(name="dbtimestamp", value=null)
	private LocalDateTime dob;
	// @UpdateTimestamp
	private LocalDateTime dob1;

	public User(int id, String name, String password, String email, String city, String mobile, LocalDateTime dob,
			LocalDateTime dob1, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.city = city;
		this.mobile = mobile;
		this.dob = dob;
		this.dob1 = dob1;
		this.role = role;
	}

	public LocalDateTime getDob1() {
		return dob1;
	}

	public void setDob1(LocalDateTime dob1) {
		this.dob1 = dob1;
	}

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime localDateTime) {
		this.dob = localDateTime;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", city=" + city
				+ ", mobile=" + mobile + ", dob=" + dob + ", dob1=" + dob1 + ", role=" + role + "]";
	}

}

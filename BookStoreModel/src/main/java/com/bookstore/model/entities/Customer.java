package com.bookstore.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bookstore.model.enumerate.AuthProvider;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_Number")
	private String phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "photo_url")
	private String photoUrl;
	
	@Column(name = "rank")
	private String rank;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "last_login")
	private String lastLogin;
	
	@Column(name = "email_verified")
	private Boolean emailVerified;
	
	@Column(name = "verification_code")
	private String verificationCode;
	
	@Column(name = "auth_provider")
	@Enumerated(EnumType.STRING)
	private AuthProvider authProvider;
	
	@Column(name = "enabled")
	private Boolean enabled;
}

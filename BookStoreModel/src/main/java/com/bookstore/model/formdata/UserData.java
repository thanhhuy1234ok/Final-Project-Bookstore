package com.bookstore.model.formdata;

import com.bookstore.model.entities.Role;
import com.bookstore.model.entities.User;

public class UserData {
	
	private Integer id;
	
	private String fullName;
	
	private String username;
	
	private String password;
	
	private String roles;
	
	public static UserData copyValueFromUserEntity(User user) {
		UserData userData = new UserData();
		
		userData.id = user.getId();
		userData.fullName = user.getFullName();
		userData.username = user.getUsername();
		userData.password = user.getPassword();
		userData.roles = "";
		for(Role userRole : user.getRoles()) {
			userData.roles += userRole.getName() + ", ";
		}
		userData.roles = userData.roles.substring(0, userData.roles.length() - 2);
		return userData;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}

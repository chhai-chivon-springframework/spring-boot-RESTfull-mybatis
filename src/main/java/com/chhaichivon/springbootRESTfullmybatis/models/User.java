package com.chhaichivon.springbootRESTfullmybatis.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/9/2017
 * TIME   : 9:58 PM
 */
public class User {
	@JsonProperty("ID")
	private int id;
	@JsonProperty("USERNAME")
	private String username;
	@JsonProperty("EMAIL")
	private String email;
	@JsonProperty("PASSWORD")
	private String password;
	@JsonProperty("ROLE")
	private Role role;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}

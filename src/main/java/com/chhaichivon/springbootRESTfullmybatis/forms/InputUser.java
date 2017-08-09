package com.chhaichivon.springbootRESTfullmybatis.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/9/2017
 * TIME   : 10:13 PM
 */
public class InputUser {

	@JsonProperty("USER_ID")
	private int userId;
	@JsonProperty("USERNAME")
	private String username;
	@JsonProperty("PASSWORD")
	private String password;
	@JsonProperty("ROLE_ID")
	private int roleId;
	@JsonProperty("EMAIL")
	private String email;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

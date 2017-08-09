package com.chhaichivon.springbootRESTfullmybatis.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/9/2017
 * TIME   : 9:58 PM
 */
public class Role {
	@JsonProperty("ID")
	private int id;
	@JsonProperty("ROLE_NAME")
	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

package com.chhaichivon.springbootRESTfullmybatis.services;

import com.chhaichivon.springbootRESTfullmybatis.models.User;

import java.util.ArrayList;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/9/2017
 * TIME   : 10:00 PM
 */
public interface UserService {
	public ArrayList<User> getUsers();
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int userId , int roleId );

}

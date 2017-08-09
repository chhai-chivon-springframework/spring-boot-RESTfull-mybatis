package com.chhaichivon.springbootRESTfullmybatis.services.impl;

import com.chhaichivon.springbootRESTfullmybatis.models.User;
import com.chhaichivon.springbootRESTfullmybatis.repository.UserRepository;
import com.chhaichivon.springbootRESTfullmybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/9/2017
 * TIME   : 10:01 PM
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ArrayList<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public boolean addUser(User user) {
		return userRepository.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userRepository.updateUser(user);
	}

	@Override
	public boolean deleteUser(int userId , int roleId) {
		return userRepository.deleteUser(userId , roleId);
	}

}
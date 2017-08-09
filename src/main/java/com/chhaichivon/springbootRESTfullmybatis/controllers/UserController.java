package com.chhaichivon.springbootRESTfullmybatis.controllers;

import com.chhaichivon.springbootRESTfullmybatis.forms.InputUser;
import com.chhaichivon.springbootRESTfullmybatis.models.Role;
import com.chhaichivon.springbootRESTfullmybatis.models.User;
import com.chhaichivon.springbootRESTfullmybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/9/2017
 * TIME   : 10:10 PM
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getUsers(){
		Map<String , Object> map = new HashMap<>();
		try{
			ArrayList<User> users = userService.getUsers();
			if(!users.isEmpty()){
				map.put("DATA", users);
				map.put("STATUS", true);
				map.put("MESSAGE", "DATA FOUND!");
			}else{
				map.put("STATUS", true);
				map.put("MESSAGE", "DATA NOT FOUND!");
			}
		}catch(Exception e){
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<>(map , HttpStatus.OK) ;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> addUser(@RequestBody InputUser user){
		Map<String,Object> map = new HashMap<>();
		try{
			User u = new User();
			u.setId(user.getUserId());
			u.setPassword(user.getPassword());
			u.setUsername(user.getUsername());
			u.setEmail(user.getEmail());
			Role role = new Role();
			role.setId(user.getRoleId());
			u.setRole(role);
			if(userService.addUser(u)){
				map.put("MESSAGE", "User has been inserted.");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "User has not been inserted.");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<>(map , HttpStatus.OK);

	}


	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody User user){
		Map<String, Object> map = new HashMap<>();
		try{
			if(userService.updateUser(user)){
				map.put("MESSAGE", "User has been updated");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "User has not been updated");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<>(map , HttpStatus.OK);
	}


	@RequestMapping(value="/{user-id}/{role-id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Map<String , Object>> deleteUser(
			@PathVariable("user-id") int id,
			@PathVariable("role-id") int roleId
//			@RequestParam(name="id" , required=false , defaultValue="1") int id
	){
		Map<String , Object> map = new HashMap<>();
		try{
			if(userService.deleteUser(id , roleId)){
				map.put("MESSAGE", "User has been deleted.");
				map.put("STATUS" , true);
			}else{
				map.put("MESSAGE", "User has not been deleted.");
				map.put("STATUS" , false);
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("MESSAGE", "Error!");
			map.put("STATUS" , false);
		}
		return new ResponseEntity<>(map , HttpStatus.OK);
	}
}

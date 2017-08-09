package com.chhaichivon.springbootRESTfullmybatis.repository;

import com.chhaichivon.springbootRESTfullmybatis.models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/9/2017
 * TIME   : 9:57 PM
 */

@Repository
public interface UserRepository {

	String R_USERS = "SELECT "
			+ "	U.user_id , "
			+ "	U.username , "
			+ "	U.password , "
			+ "	U.email , "
			+ "	R.role_id, "
			+ " R.role_name "
			+ "	FROM Users U "
			+ " INNER JOIN Roles R ON U.role_id = R.role_id";


	@Select(R_USERS)
	@Results(value={
			@Result(property="id" , column="user_id"),
			@Result(property="username" , column="username"),
			@Result(property="password" , column="password"),
			@Result(property="role.id" , column="role_id"),
			@Result(property="role.roleName" , column="role_name")
	})
	public ArrayList<User> getUsers();



	String C_USER = "INSERT INTO Users ( username , password, email, role_id ) "
			+ "VALUES ( #{username} , #{password} , #{email} , #{role.id} )";
	@Insert(C_USER)
	public boolean addUser(User user);



	String U_USER = "UPDATE Users SET "
			+ "	username=#{username} , "
			+ "	email=#{email} , "
			+ "	password=#{password} "
			+ "WHERE "
			+ "	user_id=#{id}";
	@Update(U_USER)
	public boolean updateUser(User user);


	String D_USER = "DELETE FROM Users WHERE user_id=#{userId} and role_id=#{roleId}";
	@Delete(D_USER)
	public boolean deleteUser(@Param("userId") int userId , @Param("roleId")int roleId);
}

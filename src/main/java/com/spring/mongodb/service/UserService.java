package com.spring.mongodb.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.spring.mongodb.model.User;

public interface UserService {

	
	List<User> findAllUsers();

	User findUserById(String userId);

	User saveUser(User user);

	Object findAllUserSettings(String userId);

	Map findUserSetting(String userId);

}

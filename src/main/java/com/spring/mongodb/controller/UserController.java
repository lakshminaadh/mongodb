package com.spring.mongodb.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.model.User;
import com.spring.mongodb.service.UserService;

@RestController
@Transactional
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findall(){
		List<User> allUsers=	userService.findAllUsers();
		return new ResponseEntity(allUsers, HttpStatus.OK);
		
	}
	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public ResponseEntity<List<User>>saveUser(@RequestBody User user){
		User userCreated=	userService.saveUser(user);
		return   new ResponseEntity(userCreated,HttpStatus.OK);
		
	}
	@RequestMapping(value="/userSetting/{userId}", method = RequestMethod.GET)
	public ResponseEntity<String> findUserSetting(@PathVariable String userId){
		Map userSettingBasedonid=	userService.findUserSetting(userId);
	
		//System.out.println(userSettingBasedonid);
		//Set<String> userSettingBasedonid=	userService.findUserSetting(userId);
		return  new ResponseEntity(userSettingBasedonid,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="userFindByid/{userId}",method = RequestMethod.GET)
	public ResponseEntity<User> findUserById(@PathVariable String userId){
		User findByid=userService.findUserById(userId);
		return new ResponseEntity<User>(findByid,HttpStatus.OK);
		
	}     
	

}

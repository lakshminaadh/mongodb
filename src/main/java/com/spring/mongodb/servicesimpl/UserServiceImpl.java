package com.spring.mongodb.servicesimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mongodb.model.User;
import com.spring.mongodb.repository.UserRepository;
import com.spring.mongodb.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findUserById(String userId) {
		//Query query=new Query();
		//query.addCriteria(Criteria.where("userId").is(userId));
		return userRepository.findById(userId).get();
	
	}

	@Override
	public User saveUser(User user) {
		
		User usersaved=	userRepository.save(user);
		// TODO Auto-generated method stub
		return usersaved;
	}

	@Override
	public Map<String, String> findAllUserSettings(String userId) {
		
 	User user=	userRepository.findById(userId).get();
	
		// TODO Auto-generated method stub
		return user.getUserSettings();
	}



	@Override
	public  Map findUserSetting(String userId) {
	User user=	userRepository.findById(userId).get();	
	Map m1=new HashMap();
	Map<String, String> usersetting=	user.getUserSettings();
	Set<String> set = usersetting.keySet();
	set.forEach(System.out::println);;
	for (String string : set) {
		//System.out.println();
		//usersetting.get(string);
	//m1=new HashMap();
		m1.put(string, usersetting.get(string));

	}
	
		return m1;
	}

	
	

}

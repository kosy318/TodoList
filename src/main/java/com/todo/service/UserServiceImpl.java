package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.mapper.UserMapper;
import com.todo.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper mapper;
	
	@Override
	public User login(User user) {
		return mapper.login(user);
	}

	@Override
	public void signup(User user) {
		mapper.signup(user);
	}

}

package com.todo.service;

import com.todo.vo.User;

public interface UserService {

	User login(User user);
	void signup(User user);

}

package com.todo.mapper;

import com.todo.vo.User;

public interface UserMapper {
	
	User login(User user);
	void signup(User user);

}

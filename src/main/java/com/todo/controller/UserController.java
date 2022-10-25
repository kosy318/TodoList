package com.todo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.service.UserService;
import com.todo.vo.User;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("login")
	public String login(HttpSession session) {
		if(session.getAttribute("id") != null) {
			return "redirect:/list";
		}
		
		return "login";
	}
	
	@PostMapping("login")
	public String login(HttpSession session, User user) {
		if(service.login(user) != null) {
			session.setAttribute("id", user.getId());
			return "redirect:/list";
		}
		
		return "login";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("id", null);
		
		return "redirect:/";
	}

}

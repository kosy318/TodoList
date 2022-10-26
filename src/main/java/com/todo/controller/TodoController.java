package com.todo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.service.TodoService;
import com.todo.vo.Todo;
import com.todo.vo.User;

@Controller
public class TodoController {

	@Autowired
	TodoService service;

	@GetMapping("list")
	public String allList(Model model, HttpSession session) throws Exception {
//		List<Todo> todoList = service.allList();
		User user = (User) session.getAttribute("user");
		List<Todo> todoList = service.findById(user.getId());
		if(todoList == null) todoList = new ArrayList<>(); 
		model.addAttribute("todoList", todoList);
		
		return "list";
	}
	
	@GetMapping("read")
	public String findByNum(String num, Model model) throws Exception {
		Todo todo = service.findByNum(num);
		model.addAttribute("todo", todo);
		
		return "read";
	}
	
	@GetMapping("searchAll")
	public String searchAll(String search, String word, Model model, HttpSession session) throws Exception{
		List<Todo> todoList = null;
		User user = (User) session.getAttribute("user");
		HashMap<String, String> map = new HashMap<>();
		map.put("word", word);
		map.put("id", user.getId());
//		if(search.equals("id")) todoList = service.findById(word);
		if(search.equals("date")) todoList = service.findByDate(map);
		else if(search.equals("content")) todoList = service.findByContent(map);
		model.addAttribute("todoList", todoList);
		
		return "list";
	}
	
	@GetMapping("insert")
	public String insertForm() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(Todo todo) throws Exception {
		service.add(todo);
		return "redirect:/list";
	}
	
	@GetMapping("modify")
	public String modifyForm(String num, Model model) throws Exception{
		Todo todo = service.findByNum(num);
		model.addAttribute("todo", todo);
		
		return "modify";
	}
	
	@PostMapping("modify")
	public String modifyProcess(Todo todo) throws Exception {
		service.modify(todo);
		return "redirect:/list";
	}
	
	@GetMapping("delete")
	public String delete(String num) throws Exception {
		service.delete(num);
		return "redirect:/list";
	}
	
	@GetMapping("deleteAll")
	public String deleteAll(String num) throws Exception {
		service.deleteAll();
		return "redirect:/list";
	}
	
	@GetMapping("complete")
	public String complete(String num) throws Exception {
		service.complete(num);
		return "redirect:/read?num="+num;
	}
	
	@GetMapping("change")
	public String change(String done, String num) throws Exception {
		if(done.equals("N")) service.complete(num);
		else service.incomplete(num);
		return "redirect:/list";
	}
}

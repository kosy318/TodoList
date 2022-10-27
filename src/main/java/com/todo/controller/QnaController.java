package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.service.QnaService;
import com.todo.vo.Qna;

@Controller
public class QnaController {

	@Autowired
	QnaService service;

	@GetMapping("qna-list")
	public String allList(Model model) {
		List<Qna> qnaList = service.allList();
		model.addAttribute("qnaList", qnaList);
		
		return "qna-list";
	}
	
	@GetMapping("qna-read")
	public String findByNum(String num, Model model) throws Exception {
		Qna qna = service.readOne(num);
		model.addAttribute("qna", qna);
		
		return "qna-read";
	}
	
	@GetMapping("qna-search")
	public String search(String word, Model model) throws Exception{
		List<Qna> qnaList = service.findByTitle(word);
		model.addAttribute("qnaList", qnaList);
		
		return "qna-list";
	}
	
	@GetMapping("qna-insert")
	public String insertForm() {
		return "qna-insert";
	}
	
	@PostMapping("qna-insert")
	public String insertProcess(Qna qna) throws Exception {
		service.add(qna);
		return "redirect:/qna-list";
	}
	
	@GetMapping("qna-modify")
	public String modifyForm(String num, Model model) throws Exception{
		Qna qna = service.findByNum(num);
		model.addAttribute("qna", qna);
		
		return "qna-modify";
	}
	
	@PostMapping("qna-modify")
	public String modifyProcess(Qna qna) throws Exception {
		service.modify(qna);
		return "redirect:/qna-list";
	}
	
	@GetMapping("qna-delete")
	public String delete(String num) throws Exception {
		service.delete(num);
		return "redirect:/qna-list";
	}
	
	@PostMapping("answer")
	public String answer(String num, String answer) throws Exception{
		service.answer(num);
		return "qna-read?num="+num;
	}
	
}

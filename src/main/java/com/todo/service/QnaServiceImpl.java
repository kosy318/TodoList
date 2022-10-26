package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.mapper.QnaMapper;
import com.todo.vo.Qna;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	QnaMapper mapper;

	@Override
	public List<Qna> allList() {
		return mapper.allList();
	}

	@Override
	public Qna findByNum(String num) throws Exception {
		return mapper.findByNum(num);
	}

	@Override
	@Transactional
	public Qna readOne(String num) {
		mapper.countUp(num);
		return mapper.findByNum(num);
	}

	@Override
	public List<Qna> findByTitle(String word) throws Exception {
		return mapper.findByTitle(word);
	}

	@Override
	public boolean add(Qna qna) throws Exception {
		return mapper.add(qna);
	}

	@Override
	public boolean modify(Qna qna) throws Exception {
		return mapper.modify(qna);
	}

	@Override
	public boolean delete(String num) throws Exception {
		return mapper.delete(num);
	}

}

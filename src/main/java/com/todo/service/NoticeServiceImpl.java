package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.mapper.NoticeMapper;
import com.todo.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeMapper mapper;

	@Override
	public List<Notice> allList() {
		return mapper.allList();
	}
	
	@Override
	@Transactional
	public Notice readOne(String num) {
		mapper.countUp(num);
		return mapper.findByNum(num);
	}

	@Override
	public Notice findByNum(String num) throws Exception {
		return mapper.findByNum(num);
	}

	@Override
	public List<Notice> findByContent(String word) throws Exception {
		return mapper.findByContent(word);
	}

	@Override
	public boolean add(Notice notice) throws Exception {
		return mapper.add(notice);
	}

	@Override
	public boolean modify(Notice notice) throws Exception {
		return mapper.modify(notice);
	}

	@Override
	public boolean delete(String num) throws Exception {
		return mapper.delete(num);
	}

}

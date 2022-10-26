package com.todo.service;

import java.util.List;

import com.todo.vo.Qna;

public interface QnaService {

	List<Qna> allList();// 모든 qna 목록
	Qna findByNum(String num) throws Exception;; // 번호로 검색. 상세화면
	Qna readOne(String num);
	
	// 검색창에 검색
	List<Qna> findByTitle(String word) throws Exception; // 제목으로 like 검색

	boolean add(Qna qna) throws Exception;// qna 등록
	boolean modify(Qna qna) throws Exception;// qna 내용 수정
	boolean delete(String num) throws Exception;// qna 삭제

}

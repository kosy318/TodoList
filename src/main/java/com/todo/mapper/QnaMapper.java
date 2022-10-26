package com.todo.mapper;

import java.util.List;

import com.todo.vo.Qna;

// Service를 위한 인터페이스
public interface QnaMapper {
	
	List<Qna> allList();// 모든 qna 목록
	Qna findByNum(String num); // 번호로 검색
	List<Qna> findByTitle(String word);
	
	boolean add(Qna qna); // qna 등록
	boolean modify(Qna qna);// qna 수정
	boolean delete(String num);// 삭제 기준으로 qna 삭제
	void countUp(String num);

}

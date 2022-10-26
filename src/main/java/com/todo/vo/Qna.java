package com.todo.vo;

public class Qna {
	
	private String num;
	private String title;
	private String content;
	private String answer;
	private String id;
	private String regdate;
	private int count;

	public Qna() {}
	public Qna(String num, String title, String content, String answer, String id, String regdate, int count) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.answer = answer;
		this.id = id;
		this.regdate = regdate;
		this.count = count;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

}

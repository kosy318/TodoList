package com.todo.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.todo.vo.User;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	// 컨트롤러가 호출되기 전에 실행됨: 권한 여부
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null && user.getId().equals("admin")) {
			return true; // 컨트롤러로 전달됨
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다'); location.href='notice-list';</script>");
			out.flush();
			return false;
		}
	}
}
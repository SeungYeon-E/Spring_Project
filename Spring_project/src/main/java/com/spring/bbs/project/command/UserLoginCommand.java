package com.spring.bbs.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.bbs.project.dao.LoginDao;


public class UserLoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		// TODO Auto-generated method stub
		
		//email, pw 받음.
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		//logindao에서 메소드 실행
		LoginDao dao = new LoginDao();
		//email값 불러오기
		String loginEmail = dao.loginEmail(email,pwd);
		//admin값 불러오기
		String loginAdmin = dao.loginAdmin(email,pwd);
		//deletedate값 불러오기
		String loginDeletedate = dao.loginDeletedate(email,pwd);
		
		//세션에 저장 각각 따로 사용 가능
		session.setAttribute("email", loginEmail);
		session.setAttribute("admin", loginAdmin);
		session.setAttribute("deletedate", loginDeletedate);
		
		//확인ㅁ
		System.out.println(loginEmail);
		System.out.println(loginAdmin);
		System.out.println(loginDeletedate);

	}
}

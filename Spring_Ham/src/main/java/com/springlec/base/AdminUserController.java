package com.springlec.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.command.AdminUserDeleteCommand;
import com.springlec.base.command.AdminUserRecoverCommand;
import com.springlec.base.command.AdminUserlistCommand;
import com.springlec.base.command.Command;


@Controller
public class AdminUserController {

	Command command = null;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	/*
	 * ----------------------------- 
	 * 21.07.05 seungyeon adminuser 상세페이지 
	 *   -----------------------------
	 */
	// adminuser - list 불러오기
	@RequestMapping("/AdminUserlist")
	public String AdminUserlist(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new AdminUserlistCommand();
		command.execute(model, httpSession, sqlSession);
		return "AdminUserList";
	}
	
	@RequestMapping("/AdminUserDelete")
	public String AdminUserDelete(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new AdminUserDeleteCommand();
		command.execute(model, httpSession, sqlSession);
		return "AdminUserDeleteView";
	}
	
	@RequestMapping("/AdminUserRecover")
	//세션쓰면 같이 넣어줘
	public String AdminUserRecover(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new AdminUserRecoverCommand();
		command.execute(model, httpSession, sqlSession);
		return "AdminUserRecoverView";
	}
	
//	@RequestMapping("/AdminUserSearch")
//	//세션쓰면 같이 넣어줘
//	public String AdminUserSearch(HttpServletRequest request, Model model, HttpSession httpSession) {
////		model.addAttribute("request", request);
//		command = new AdminuserSearchCommand();
//		command.execute(model, httpSession, sqlSession);
//		return "AdminUserList";
//	}
//	
	
}
package com.spring.bbs.project.homecontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bbs.project.command.AdminUserDeleteCommand;
import com.spring.bbs.project.command.AdminUserRecoverCommand;
import com.spring.bbs.project.command.AdminUserlistCommand;
import com.spring.bbs.project.command.AdminuserSearchCommand;
import com.spring.bbs.project.command.Command;

@Controller
public class AdminUserController {
	
//	@Autowired
//	private SqlSession sqlSession;
	
	Command command = null;
	
	/*
	 * ----------------------------- 
	 * 21.07.05 seungyeon adminuser 상세페이지 
	 *   -----------------------------
	 */
	// adminuser - list 불러오기
	@RequestMapping("/AdminUserlist")
	//세션쓰면 같이 넣어줘
	public String AdminUserlist(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new AdminUserlistCommand();
		command.execute(model, httpSession);
		return "AdminUserList";
	}
	
	@RequestMapping("/AdminUserDelete")
	//세션쓰면 같이 넣어줘
	public String AdminUserDelete(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new AdminUserDeleteCommand();
		command.execute(model, httpSession);
		return "AdminUserDeleteView";
	}
	
	@RequestMapping("/AdminUserRecover")
	//세션쓰면 같이 넣어줘
	public String AdminUserRecover(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new AdminUserRecoverCommand();
		command.execute(model, httpSession);
		return "AdminUserRecoverView";
	}
	
	@RequestMapping("/AdminUserSearch")
	//세션쓰면 같이 넣어줘
	public String AdminUserSearch(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new AdminuserSearchCommand();
		command.execute(model, httpSession);
		return "AdminUserList";
	}
	
	
}

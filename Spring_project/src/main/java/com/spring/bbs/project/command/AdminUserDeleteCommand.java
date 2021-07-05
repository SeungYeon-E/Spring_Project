package com.spring.bbs.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.spring.bbs.project.dao.AdminUserdao;

public class AdminUserDeleteCommand implements Command {

	@Override
	public void execute(Model model, HttpSession httpSession) {
		
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String user_email =request.getParameter("user_email");
		AdminUserdao dao = new AdminUserdao();
		String result = dao.userDelete(user_email);
		
//		request.setAttribute("result", result);
		 
		model.addAttribute("result", result);
		
	}

}

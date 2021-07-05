package com.spring.bbs.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.bbs.project.dao.ContentItemdao;

public class ContentItemDeleteCommand implements Command {

	@Override
	public void execute(Model model, HttpSession httpSession) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String i_num =request.getParameter("i_num");
		
		ContentItemdao dao = new ContentItemdao();
		String result = dao.contentDelete(i_num);
//		request.setAttribute("result", result);
		model.addAttribute("result", result);
	}

}

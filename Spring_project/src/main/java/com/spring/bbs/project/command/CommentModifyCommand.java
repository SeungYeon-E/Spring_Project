package com.spring.bbs.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.bbs.project.dao.ContentItemdao;


public class CommentModifyCommand implements Command {

	@Override
	public void execute(Model model, HttpSession httpSession) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		// TODO Auto-generated method stub
		String ic_num =request.getParameter("ic_num");
		String ic_content = request.getParameter("ic_content");
		
		ContentItemdao dao = new ContentItemdao();
		String result = dao.commentModiey(ic_num, ic_content);
		
//		request.setAttribute("result", result);
		model.addAttribute("result", result);
		
	}

}

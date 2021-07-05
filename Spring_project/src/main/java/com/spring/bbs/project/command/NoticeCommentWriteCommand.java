package com.spring.bbs.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.bbs.project.dao.ContentNoticedao;

public class NoticeCommentWriteCommand implements Command {

	@Override
	public void execute(Model model, HttpSession httpSession) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String n_num = request.getParameter("n_num");
		
		String myEmail = (String) httpSession.getAttribute("email");
		String nc_content = request.getParameter("nc_content");
		ContentNoticedao dao = new ContentNoticedao();
		String result = dao.commentWrite(n_num, myEmail, nc_content);

//		request.setAttribute("result", result);
		model.addAttribute("result", result);
	}

}

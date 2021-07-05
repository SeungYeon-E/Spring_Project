package com.spring.bbs.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.bbs.project.dao.ContentItemdao;
import com.spring.bbs.project.dto.ContentItemdto;

public class CommentContentCommand implements Command {

	@Override
	public void execute(Model model, HttpSession httpSession) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String ic_num =request.getParameter("ic_num");
		
		ContentItemdao dao = new ContentItemdao();
		ContentItemdto dto = dao.commentContent(ic_num);
		
//		request.setAttribute("commentcontent_view", dto);
		model.addAttribute("commentcontent_view", dto);
	}

}

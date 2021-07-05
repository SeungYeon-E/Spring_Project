package com.spring.bbs.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.bbs.project.dao.NoticeDao;

public class NoticeInsertCommand implements Command {

	@Override
	public void execute(Model model, HttpSession httpSession) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String N_TITLE = request.getParameter("N_TITLE");
		String N_CONTENT = request.getParameter("N_CONTENT");
		String myEmail = (String) httpSession.getAttribute("email");

		NoticeDao NoticeDao = new NoticeDao();
		int n_num = NoticeDao.write(N_TITLE, N_CONTENT,myEmail);
//		request.setAttribute("result", n_num);
		model.addAttribute("result", n_num);

	}

}

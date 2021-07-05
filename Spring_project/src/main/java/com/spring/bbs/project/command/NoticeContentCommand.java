package com.spring.bbs.project.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.bbs.project.dao.NoticeDao;
import com.spring.bbs.project.dto.NoticeDto;



public class NoticeContentCommand implements Command {

	@Override
	public void execute(Model model, HttpSession httpSession) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String N_NUM =request.getParameter("n_num");
		NoticeDao noticeDao = new NoticeDao();
		NoticeDto noticeDto = noticeDao.read(N_NUM);
//		request.setAttribute("read", noticeDto);
		model.addAttribute("read", noticeDto);

	}

}

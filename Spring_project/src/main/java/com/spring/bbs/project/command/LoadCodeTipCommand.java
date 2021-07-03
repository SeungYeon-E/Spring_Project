package com.spring.bbs.project.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.bbs.project.dao.TipsDao;
import com.spring.bbs.project.dto.PostDto;

public class LoadCodeTipCommand implements Command {
	int numOfTuplesPerPage = 15;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		// TODO Auto-generated method stub

		TipsDao dao = new TipsDao();
		int requestPage = 1;
		session = request.getSession();
		
		if ( request.getParameter("page") != null) {
			int posts = (int)session.getAttribute("postsCount");
			requestPage = posts + numOfTuplesPerPage;
			session.setAttribute("postsCount", requestPage);
		}
		
		ArrayList<PostDto> dtos = dao.listCode(requestPage, numOfTuplesPerPage);
		request.setAttribute("list", dtos);
		session.setAttribute("CATEGORY", "TIP");
		session.setAttribute("TITLE", "T_TITLE");
		session.setAttribute("do", "codeTipLsit.do");
	}

}

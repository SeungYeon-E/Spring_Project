package com.spring.bbs.project.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.bbs.project.dao.ItemsDao;
import com.spring.bbs.project.dto.PostDto;


public class LoadItemsCommand implements Command {

	int numOfTuplesPerPage = 15;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		ItemsDao dao = new ItemsDao();
		int requestPage = 1;
		session = request.getSession();
		
		
		if ( request.getParameter("page") != null) {
			int posts = (int)session.getAttribute("postsCount");
			requestPage = posts + numOfTuplesPerPage;
			session.setAttribute("postsCount", requestPage);
		}
		
		ArrayList<PostDto> dtos = dao.list(requestPage, numOfTuplesPerPage);
		request.setAttribute("list", dtos);
		session.setAttribute("CATEGORY", "ITEM");
		session.setAttribute("CONDITION", "I_TITLE");
		session.setAttribute("do", "lsit2.do");
	}
	
	

}

package com.spring.bbs.project.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.bbs.project.dao.MyPostDao;
import com.spring.bbs.project.dao.ProfileDao;
import com.spring.bbs.project.dto.PostDto;
import com.spring.bbs.project.dto.ProfileDto;

public class LoadUsersItem implements Command {

	int numOfTuplesPerPage = 10;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		
		String currentUser = "'"+(String)session.getAttribute("stranger")+"'";
		
		ProfileDao profileDao = new ProfileDao();
		ProfileDto dto = profileDao.loadProfile(currentUser);

		int requestPage = 1;
		MyPostDao listDao = new MyPostDao();
		
		session = request.getSession();
		
		
		if ( request.getParameter("page") != null) {
			requestPage = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("courrentPage", requestPage);
		}

		int countedTuple = listDao.selectItem(currentUser);

		ArrayList<Integer> pageList = calcNumOfPage(countedTuple);
		session.setAttribute("pageList", pageList);
		ArrayList<PostDto> dtos = listDao.myItemList(currentUser, requestPage, numOfTuplesPerPage);
		request.setAttribute("myList", dtos);
		
		request.setAttribute("myprofile", dto);
		request.setAttribute("count", Integer.toString(countedTuple));
		session.setAttribute("do", "userOnlyItem.do");
	}
	
	public ArrayList<Integer> calcNumOfPage(int countedTuple) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int calcPage = 0;
		if (countedTuple % numOfTuplesPerPage == 0) {
			calcPage = countedTuple / numOfTuplesPerPage;
		} else {
			calcPage = countedTuple / numOfTuplesPerPage + 1;
		}
		for (int i = 1; i <= calcPage; i++) {
			System.out.println(i);
			arr.add(i);
		}
		return arr;
	}

}

package com.spring.bbs.project.homecontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bbs.project.command.Command;
import com.spring.bbs.project.command.CommentContentCommand;
import com.spring.bbs.project.command.CommentDeleteCommand;
import com.spring.bbs.project.command.CommentModifyCommand;
import com.spring.bbs.project.command.CommentWriteCommand;
import com.spring.bbs.project.command.ContentItemCommand;
import com.spring.bbs.project.command.ContentItemDeleteCommand;

@Controller
public class ItemContentController {
	
//	@Autowired
//	private SqlSession sqlSession;
	
	Command command = null;
	
	/*
	 * ----------------------------- 
	 * 21.07.05 seungyeon Item 상세페이지 
	 *   -----------------------------
	 */
	// Item - 상세페이지 불러오기
	@RequestMapping("/ContentViewItem")
	//세션쓰면 같이 넣어줘
	public String ContentViewItem(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new ContentItemCommand();
		command.execute(model, httpSession);
		return "ContentViewItem";
	}
	// Item - 상세페이지 게시물 삭제하기
	@RequestMapping("/ContentViewItemdelete")
	//세션쓰면 같이 넣어줘
	public String ContentViewItemdelete(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new ContentItemDeleteCommand();
		command.execute(model, httpSession);
		return "ContentDeleteView";
	}
	// Item - Item - 상세페이지 댓글입력
	@RequestMapping("/CommentWriteItem")
	//세션쓰면 같이 넣어줘
	public String CommentWriteItem(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new CommentWriteCommand();
		command.execute(model, httpSession);
		return "CommentWriteView";
	}
	// Item - 상세페이지 댓글 불러오기
	@RequestMapping("/CommentContentItem")
	//세션쓰면 같이 넣어줘
	public String CommentContentItem(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new CommentContentCommand();
		command.execute(model, httpSession);
		return "CommentContentView";
	}
	// Item - 상세페이지 댓글 수정하기
	@RequestMapping("/CommentModifyItem")
	//세션쓰면 같이 넣어줘
	public String CommentModifyItem(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new CommentModifyCommand();
		command.execute(model, httpSession);
		return "CommentModifyView";
	}
	// Item - 상세페이지 댓글 삭제하기
	@RequestMapping("/CommentDeleteItem")
	//세션쓰면 같이 넣어줘
	public String CommentDeleteItem(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new CommentDeleteCommand();
		command.execute(model, httpSession);
		return "CommentDeleteView";
	}
	
	
}

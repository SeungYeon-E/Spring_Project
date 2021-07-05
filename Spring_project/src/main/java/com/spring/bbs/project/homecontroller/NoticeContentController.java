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
import com.spring.bbs.project.command.ContentNoticeCommand;
import com.spring.bbs.project.command.ContentNoticeDeleteCommand;
import com.spring.bbs.project.command.NoticeCommentContentCommand;
import com.spring.bbs.project.command.NoticeCommentDeleteCommand;
import com.spring.bbs.project.command.NoticeCommentModifyCommand;
import com.spring.bbs.project.command.NoticeCommentWriteCommand;

@Controller
public class NoticeContentController {
	
//	@Autowired
//	private SqlSession sqlSession;
	
	Command command = null;
	
	/*
	 * ----------------------------- 
	 * 21.07.05 seungyeon notice 상세페이지 
	 *   -----------------------------
	 */
	// notice - 상세페이지 불러오기
	@RequestMapping("/ContentViewNotice")
	//세션쓰면 같이 넣어줘
	public String ContentViewNotice(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new ContentNoticeCommand();
		command.execute(model, httpSession);
		return "ContentViewNotice";
	}
	// notice - 상세페이지 게시물 삭제하기
	@RequestMapping("/ContentViewNoticedelete")
	//세션쓰면 같이 넣어줘
	public String ContentViewNoticedelete(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new ContentNoticeDeleteCommand();
		command.execute(model, httpSession);
		return "ContentDeleteView";
	}
	// notice - Item - 상세페이지 댓글입력
	@RequestMapping("/NoticeCommentWrite")
	//세션쓰면 같이 넣어줘
	public String NoticeCommentWrite(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new NoticeCommentWriteCommand();
		command.execute(model, httpSession);
		return "CommentWriteView";
	}
	// notice - 상세페이지 댓글 불러오기
	@RequestMapping("/NoticeCommentContent")
	//세션쓰면 같이 넣어줘
	public String NoticeCommentContent(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new NoticeCommentContentCommand();
		command.execute(model, httpSession);
		return "NoticeCommentContentView";
	}
	// notice - 상세페이지 댓글 수정하기
	@RequestMapping("/NoticeCommentModify")
	//세션쓰면 같이 넣어줘
	public String NoticeCommentModify(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new NoticeCommentModifyCommand();
		command.execute(model, httpSession);
		return "CommentModifyView";
	}
	// notice - 상세페이지 댓글 삭제하기
	@RequestMapping("/NoticeCommentDelete")
	//세션쓰면 같이 넣어줘
	public String NoticeCommentDelete(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new NoticeCommentDeleteCommand();
		command.execute(model, httpSession);
		return "CommentDeleteView";
	}
	
	
}

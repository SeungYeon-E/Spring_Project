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
import com.spring.bbs.project.command.ContentTipCommand;
import com.spring.bbs.project.command.ContentTipDeleteCommand;
import com.spring.bbs.project.command.TipCommentContentCommand;
import com.spring.bbs.project.command.TipCommentDeleteCommand;
import com.spring.bbs.project.command.TipCommentModifyCommand;
import com.spring.bbs.project.command.TipCommentWriteCommand;

@Controller
public class TipContentController {
	
//	@Autowired
//	private SqlSession sqlSession;
	
	Command command = null;

	/*
	 * ----------------------------- 
	 * 21.07.05 seungyeon tip 상세페이지 
	 *   -----------------------------
	 */
	// tip - 상세페이지 불러오기
	@RequestMapping("/ContentViewTip")
	//세션쓰면 같이 넣어줘
	public String ContentViewTip(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new ContentTipCommand();
		command.execute(model, httpSession);
		return "ContentViewTip";
	}
	
	// tip - 상세페이지 게시물 삭제하기
	@RequestMapping("/ContentViewTipdelete")
	//세션쓰면 같이 넣어줘
	public String ContentViewTipdelete(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new ContentTipDeleteCommand();
		command.execute(model, httpSession);
		return "ContentDeleteView";
	}
	
	// tip - 상세페이지 댓글입력
	@RequestMapping("/TipCommentWrite")
	//세션쓰면 같이 넣어줘
	public String TipCommentWrite(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new TipCommentWriteCommand();
		command.execute(model, httpSession);
		return "CommentWriteView";
	}
	
	// tip - 상세페이지 댓글 불러오기
	@RequestMapping("/TipCommentContent")
	//세션쓰면 같이 넣어줘
	public String TipCommentContent(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new TipCommentContentCommand();
		command.execute(model, httpSession);
		return "TipCommentContentView";
	}
	
	// tip - 상세페이지 댓글 수정하기
	@RequestMapping("/TipCommentModify")
	//세션쓰면 같이 넣어줘
	public String TipCommentModify(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new TipCommentModifyCommand();
		command.execute(model, httpSession);
		return "CommentModifyView";
	}
	
	// tip - 상세페이지 댓글 삭제하기
	@RequestMapping("/TipCommentDelete")
	//세션쓰면 같이 넣어줘
	public String TipCommentDelete(HttpServletRequest request, Model model, HttpSession httpSession) {
		model.addAttribute("request", request);
		command = new TipCommentDeleteCommand();
		command.execute(model, httpSession);
		return "CommentDeleteView";
	}	
	
}

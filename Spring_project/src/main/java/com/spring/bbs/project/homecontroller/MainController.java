package com.spring.bbs.project.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.bbs.project.command.AdminUserDeleteCommand;
import com.spring.bbs.project.command.AdminUserRecoverCommand;
import com.spring.bbs.project.command.AdminUserlistCommand;
import com.spring.bbs.project.command.AdminuserSearchCommand;
import com.spring.bbs.project.command.ChangePasswordCommand;
import com.spring.bbs.project.command.Command;
import com.spring.bbs.project.command.CommentContentCommand;
import com.spring.bbs.project.command.CommentDeleteCommand;
import com.spring.bbs.project.command.CommentModifyCommand;
import com.spring.bbs.project.command.CommentWriteCommand;
import com.spring.bbs.project.command.ContentItemCommand;
import com.spring.bbs.project.command.ContentItemDeleteCommand;
import com.spring.bbs.project.command.ContentNoticeCommand;
import com.spring.bbs.project.command.ContentNoticeDeleteCommand;
import com.spring.bbs.project.command.ContentTipCommand;
import com.spring.bbs.project.command.ContentTipDeleteCommand;
import com.spring.bbs.project.command.DeleteAccountCommand;
import com.spring.bbs.project.command.DonateCommand;
import com.spring.bbs.project.command.DonateSumCommand;
import com.spring.bbs.project.command.EditProfileCommand;
import com.spring.bbs.project.command.EditProfileViewCommand;
import com.spring.bbs.project.command.ItemInfoContentCommand;
import com.spring.bbs.project.command.ItemInfoInsertCommand;
import com.spring.bbs.project.command.ItemInfoUpdateCommand;
import com.spring.bbs.project.command.LoadAccItemCommand;
import com.spring.bbs.project.command.LoadCodeTipCommand;
import com.spring.bbs.project.command.LoadComItemCommand;
import com.spring.bbs.project.command.LoadDeskItemCommand;
import com.spring.bbs.project.command.LoadInfoTipCommand;
import com.spring.bbs.project.command.LoadItemsCommand;
import com.spring.bbs.project.command.LoadMyAllCommand;
import com.spring.bbs.project.command.LoadMyItemCommand;
import com.spring.bbs.project.command.LoadMyTipCommand;
import com.spring.bbs.project.command.LoadNoticeCommand;
import com.spring.bbs.project.command.LoadOtherItemCommand;
import com.spring.bbs.project.command.LoadOtherTipCommand;
import com.spring.bbs.project.command.LoadProtoTipCommand;
import com.spring.bbs.project.command.LoadTipsCommand;
import com.spring.bbs.project.command.LoadUserInfo;
import com.spring.bbs.project.command.LoadUsersItem;
import com.spring.bbs.project.command.LoadUsersTip;
import com.spring.bbs.project.command.NoticeCommentContentCommand;
import com.spring.bbs.project.command.NoticeCommentDeleteCommand;
import com.spring.bbs.project.command.NoticeCommentModifyCommand;
import com.spring.bbs.project.command.NoticeCommentWriteCommand;
import com.spring.bbs.project.command.NoticeContentCommand;
import com.spring.bbs.project.command.NoticeInsertCommand;
import com.spring.bbs.project.command.NoticeUpdateCommand;
import com.spring.bbs.project.command.SearchingCommand;
import com.spring.bbs.project.command.TipCommentContentCommand;
import com.spring.bbs.project.command.TipCommentDeleteCommand;
import com.spring.bbs.project.command.TipCommentModifyCommand;
import com.spring.bbs.project.command.TipCommentWriteCommand;
import com.spring.bbs.project.command.TipContentCommand;
import com.spring.bbs.project.command.TipInsertCommand;
import com.spring.bbs.project.command.TipUpdateCommand;
import com.spring.bbs.project.command.UserEmailSearchCommand;
import com.spring.bbs.project.command.UserLoginCommand;
import com.spring.bbs.project.command.UserPwdSearchCommand;
import com.spring.bbs.project.command.UserRegisterCommand;


/**
 * Servlet implementation class MainController
 */
@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost()");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("actionDo()");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		String viewPage = null;
		Command command = null;
		
		switch(com) {
		
		/*
		 * ------------------------------------
		 * ?????????
		 * 
		 * ?????? ????????? ??????
		 */
		
//		//????????? ????????? ??????
//		case("/Login.do"): // ????????? ~~.do??????
//			viewPage = "Login.jsp"; // ????????? jsp??????
//		break;
//		
//		//???????????? ????????? ?????? 
//		case("/Signup.do"): // ????????? ~~.do??????
//			viewPage = "Signup.jsp"; // ????????? jsp??????
//			break;
//		
//		//????????????
//		case("/TermsAndConditions.do"): // ????????? ~~.do??????
//			viewPage = "TermsAndConditions.jsp"; // ????????? jsp??????
//		break;
//		
//		//???????????? ????????????
//		case("/PrivacyPolicy.do"): // ????????? ~~.do??????
//			viewPage = "PrivacyPolicy.jsp"; // ????????? jsp??????
//		break;
//		
//		//????????? ???????????????
//		case("/EmailCheckForm.do"): // ????????? ~~.do??????
//			viewPage = "EmailSearch.jsp"; // ????????? jsp??????
//		break;
//		
//		//???????????? ???????????????
//		case("/PwdCheckForm.do"): // ????????? ~~.do??????
//			viewPage = "PwdSearch.jsp"; // ????????? jsp??????
//		break;
//		
//		//????????????
//		case("/Main.do"): // ????????? ~~.do??????
//			session.setAttribute("postsCount", 1);
//			viewPage = "Main.jsp";
//		break;
//		
//		//????????????
//		case("/Logout.do"): // ????????? ~~.do??????
//			//?????????
//			session.invalidate();
//			viewPage = "Login.jsp"; // ????????? jsp??????
//		break;
//		
//		//????????????????????? ??????
//		case("/naver.do"): // ????????? ~~.do??????
//			viewPage = "naverCallback.jsp"; // ????????? jsp??????
//		break;
//	
//		
//		/*
//		 * ????????? ??????
//		 */
//		
//		//????????????
//		case("/register.do"):
//			command = new UserRegisterCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			viewPage = "SignupSuccess.jsp";
//			break;
//		//????????? ?????????	
//		case("/loginClick.do"):
//			command = new UserLoginCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			
//			//????????? ???????????? ???????????? ???????????? ????????? ?????????????????? ????????? ??????????????? ?????? ????????? ???????????? ?????????...
//			if(session.getAttribute("email").equals("")) {
//				session.invalidate();
//				viewPage = "LoginFail.jsp"; //?????? ????????? ?????????
//			}else if
//			(session.getAttribute("deletedate")==null) {
//				viewPage = "Main.jsp"; //?????????		
//			}else {
//				session.invalidate();
//				viewPage = "LoginWithdraw.jsp"; //????????????	
//			}
//			break;
//		
//		//????????? ????????????
//		case("/EmailCheck.do"):
//		command = new UserEmailSearchCommand(); // ?????????(?????????)??????
//		command.execute(request, response, session);
//		viewPage = "Signup.do";
//		break;
//		
//		//????????? ?????? ?????? ?????? ???
//		case("/EmailSearch.do"):
//			command = new UserEmailSearchCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			
//			if(session.getAttribute("searchEmail").equals("")) {
//				session.invalidate();
//				viewPage = "EmailSearchFail.jsp"; //?????????
//			
//			}else if(session.getAttribute("searchDeletedate")==null) {
//				viewPage = "EmailSearchSuccess.jsp"; //?????????	
//			
//			}else {
//				viewPage = "EmailSearchWithdraw.jsp"; //????????????	
//			}
//
//			break;
//		
//		//???????????? ?????? ?????? ?????? ???
//		case("/PwdSearch.do"):
//			command = new UserPwdSearchCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			
//			if(session.getAttribute("searchPwd").equals("")) {
//				session.invalidate();
//				viewPage = "PwdSearchFail.jsp"; //?????????
//			}else if(session.getAttribute("searchDeletedate")==null) {
//				viewPage = "PwdSearchSuccess.jsp"; //?????????
//			}else {
//				session.invalidate();
//				viewPage = "PwdSearchWithdraw.jsp"; //????????????
//			}
//			
//			break;
//			
//		//??????
//		case("/Donation.do"): // ????????? ~~.do??????
//			command = new DonateSumCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			viewPage = "Donation.jsp"; // ????????? jsp??????
//		break;
//		
//		//???????????? ?????????
//		case("/DonateClick.do"): // ????????? ~~.do??????
//			command = new DonateCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			viewPage = "DonationSuccess.jsp"; // ????????? jsp??????
//			break;
//
//			//----------------------------------------?????????
//	
//			/*
//			 * ----------------------------- 
//			 * 21.05.21 seungyeon Item ??????????????? 
//			 * ?????? userEmail ?????? ???????????? ?????????
//			 *  -> ??????????????? ????????? ???????????? list??? ???????????? ???????????????
//			 *   -----------------------------
//			 */
//			// Item - ??????????????? ???????????? 0517 ?????????
//			case ("/ContentViewItem.do"): // ????????? ~~.do??????
//				command = new ContentItemCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "ContentViewItem.jsp"; // ????????? jsp??????
//				break;
//			// Item - ??????????????? ????????? ???????????? 0518 ?????????
//			case ("/ContentViewItemdelete.do"):
//				command = new ContentItemDeleteCommand();
//				command.execute(request, response, session);
//				viewPage = "ContentDeleteView.jsp"; // ????????? jsp??????
//				break;
//			// Item - ??????????????? ???????????? 0518 ?????????
//			case ("/CommentWriteItem.do"): // ????????? ~~.do??????
//				command = new CommentWriteCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "CommentWriteView.jsp"; // ????????? jsp??????
//				break;
//				
//				
//				
//			// Item - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/CommentContentItem.do"):
//				command = new CommentContentCommand();
//				command.execute(request, response, session);
//				viewPage = "CommentContentView.jsp"; // ????????? jsp??????
//				break;
//				
//				
//				
//				
//				
//				
//			// Item - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/CommentModifyItem.do"):
//				command = new CommentModifyCommand();
//				command.execute(request, response, session);
//				viewPage = "CommentModifyView.jsp"; // ????????? jsp??????
//				break;
//			// Item - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/CommentDeleteItem.do"):
//				command = new CommentDeleteCommand();
//				command.execute(request, response, session);
//				viewPage = "CommentDeleteView.jsp"; // ????????? jsp??????
//				break;
//			/*
//			 * ----------------------------- 
//			 * 21.05.23 seungyeon tip ??????????????? 
//			 * ?????? userEmail ?????? ???????????? ?????????
//			 *  -> ??????????????? ????????? ???????????? list??? ???????????? ???????????????
//			 *   -----------------------------
//			 */	
//			// tip - ??????????????? ???????????? 0523 ?????????
//			case ("/ContentViewTip.do"): // ????????? ~~.do??????
//				command = new ContentTipCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "ContentViewTip.jsp"; // ????????? jsp??????
//				break;
//			// tip - ??????????????? ????????? ???????????? 0518 ?????????
//			case ("/ContentViewTipdelete.do"):
//				command = new ContentTipDeleteCommand();
//				command.execute(request, response, session);
//				viewPage = "ContentDeleteView.jsp"; // ????????? jsp??????
//				break;
//			// tip - ??????????????? ???????????? 0518 ?????????
//			case ("/TipCommentWrite.do"): // ????????? ~~.do??????
//				command = new TipCommentWriteCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "CommentWriteView.jsp"; // ????????? jsp??????
//				break;
//			// tip - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/TipCommentContent.do"):
//				command = new TipCommentContentCommand();
//				command.execute(request, response, session);
//				viewPage = "TipCommentContentView.jsp"; // ????????? jsp??????
//				break;
//			// tip - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/TipCommentModify.do"):
//				command = new TipCommentModifyCommand();
//				command.execute(request, response, session);
//				viewPage = "CommentModifyView.jsp"; // ????????? jsp??????
//				break;
//			// tip - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/TipCommentDelete.do"):
//				command = new TipCommentDeleteCommand();
//				command.execute(request, response, session);
//				viewPage = "CommentDeleteView.jsp"; // ????????? jsp??????
//				break;
//			/*
//			 * ----------------------------- 
//			 * 21.05.23 seungyeon notice ??????????????? 
//			 * ?????? userEmail ?????? ???????????? ?????????
//			 *  -> ??????????????? ????????? ???????????? list??? ???????????? ???????????????
//			 *   -----------------------------
//			 */	
//			// notice - ??????????????? ???????????? 0523 ?????????
//			case ("/ContentViewNotice.do"): // ????????? ~~.do??????
//				command = new ContentNoticeCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "ContentViewNotice.jsp"; // ????????? jsp??????
//				break;
//			// notice - ??????????????? ????????? ???????????? 0518 ?????????
//			case ("/ContentViewNoticedelete.do"):
//				command = new ContentNoticeDeleteCommand();
//				command.execute(request, response, session);
//				viewPage = "ContentDeleteView.jsp"; // ????????? jsp??????
//				break;
//			// notice - ??????????????? ???????????? 0518 ?????????
//			case ("/NoticeCommentWrite.do"): // ????????? ~~.do??????
//				command = new NoticeCommentWriteCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "CommentWriteView.jsp"; // ????????? jsp??????
//				break;
//			// notice - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/NoticeCommentContent.do"):
//				command = new NoticeCommentContentCommand();
//				command.execute(request, response, session);
//				viewPage = "NoticeCommentContentView.jsp"; // ????????? jsp??????
//				break;
//			// notice - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/NoticeCommentModify.do"):
//				command = new NoticeCommentModifyCommand();
//				command.execute(request, response, session);
//				viewPage = "CommentModifyView.jsp"; // ????????? jsp??????
//				break;
//			// notice - ??????????????? ?????? ???????????? 0521 ?????????
//			case ("/NoticeCommentDelete.do"):
//				command = new NoticeCommentDeleteCommand();
//				command.execute(request, response, session);
//				viewPage = "CommentDeleteView.jsp"; // ????????? jsp??????
//				break;
//			/*
//			 * ----------------------------- 
//			 * 21.05.24 seungyeon adminuser ??????????????? 
//			 *   -----------------------------
//			 */	
//			// adminuser - list ???????????? 0523 ?????????
//			case ("/AdminUserlist.do"): // ????????? ~~.do??????
//				command = new AdminUserlistCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "AdminUserList.jsp"; // ????????? jsp??????
//				break;
//			case ("/AdminUserDelete.do"): // ????????? ~~.do??????
//				command = new AdminUserDeleteCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "AdminUserDeleteView.jsp"; // ????????? jsp??????
//				break;
//			case ("/AdminUserRecover.do"): // ????????? ~~.do??????
//				command = new AdminUserRecoverCommand(); // ?????????(?????????)??????
//				command.execute(request, response, session);
//				viewPage = "AdminUserRecoverView.jsp"; // ????????? jsp??????
//				break;
//				//?????????  ?????????
//			case("/AdminUserSearch.do"):
//				command = new AdminuserSearchCommand();
//				command.execute(request, response, session);
//				viewPage = "AdminUserList.jsp";
//				break;
//
//				//-----------------------------------------??????
//
//			
//			//???????????????
//			case("/list.do"):
////				session.setAttribute("postsCount", 1);
//				command = new LoadItemsCommand();
//				command.execute(request, response, session);
//				viewPage = "ListItem.jsp";
//				break;
//			
//			//?????????	
//			case("/list2.do"):
////				session.setAttribute("postsCount", 1);
//				command = new LoadTipsCommand();
//				command.execute(request, response, session);
//				viewPage = "ListTIp.jsp";
//				break;
//				
//			//??????????????????	
//			case("/list3.do"):
////				session.setAttribute("postsCount", 1);
//				command = new LoadNoticeCommand();
//				command.execute(request, response, session);
//				viewPage = "ListNotice.jsp";
//				break;
//			
//			//?????????  ?????????
//			case("/search.do"):
//				command = new SearchingCommand();
//				command.execute(request, response, session);
//				viewPage = "ListItem.jsp";
//				break;
//				
//				
//			//??????????????? ????????? ?????? ????????? ????????????
//			case("/profile.do"):
//				command = new LoadMyItemCommand();
//				command.execute(request, response, session);
//				viewPage = "ProfileWithItem.jsp";
//				break;
//				
//			//????????????????????? ????????????????????? ?????????	
//			case("/profileOnlyTool.do"):
//				command = new LoadMyItemCommand();
//				command.execute(request, response, session);
//				viewPage = "ProfileWithItem.jsp";
//				break;
//				
//			//????????????????????? ??????????????? ?????????	
//			case("/profileOnlyIdea.do"):
//				command = new LoadMyTipCommand();
//				command.execute(request, response, session);
//				viewPage = "ProfileWithTip.jsp";
//				break;
//			
//			//-------------------------------------??????
//
//			//Tip ?????? ??? ??????
//		
//		//Tip ??? ???
//		case("/TipViewBoard.do"): 	
//		viewPage = "TipView.jsp";
//		break;
//
//			//Tip ??? ????????????
//		case("/TipInsertBoard.do"): 
//			command = new TipInsertCommand();
//			command.execute(request, response, session);	
//			int t_num = (int) request.getAttribute("result");
//			if(t_num != 0) {
//				viewPage = "ContentViewTips.do?t_num=" + t_num;
//			}else {
//				return;
//			}
//			break;
//			
//		case ("/ContentViewTips.do"): // ????????? ~~.do??????
//			command = new ContentTipCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			viewPage = "TipResultView.jsp"; // ????????? jsp??????
//			break;
//			
//			//Tip ??? ????????????
//		case("/TipContentBoard.do"): 
//			command = new TipContentCommand();
//			command.execute(request, response, session);	
//			viewPage = "TipUpdateBoard.jsp";
//		break;
//
//			//Tip ??? ????????????
//		case("/TipUpdateBoard.do"): 
//			command = new TipUpdateCommand();
//			command.execute(request, response, session);	
//			int t_num1 = (int) request.getAttribute("result");
//			if(t_num1 != 0) {
//				viewPage = "ContentViewTips.do?t_num=" + t_num1;
//			}else {
//				return;
//			}
//			break;
//		
//		//Item ?????? ??? ??????
//			
//			//Item ??? ???
//		case("/ItemInfoView.do"): 	
//			viewPage = "ItemInfoView.jsp"; 
//			break;
//			
//			//Item ??? ????????????
//		case("/ItemInfoInsert.do"): 
//			command = new ItemInfoInsertCommand();
//			command.execute(request, response, session);
//			int i_num = (int) request.getAttribute("result");
//			if(i_num != 0) {
//				viewPage = "ContentViewItems.do?i_num=" + i_num;
//			}else {
//				return;
//			}
//			break;
//			
//		case ("/ContentViewItems.do"): // ????????? ~~.do??????
//			command = new ContentItemCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			viewPage = "ItemInfoResultView.jsp"; // ????????? jsp??????
//			break;
//			
//			//Item ??? ????????????
//		case("/ItemInfoContent.do"): 
//			command = new ItemInfoContentCommand();
//			command.execute(request, response, session);	
//			viewPage = "ItemInfoUpdate.jsp";
//		break;
//		
//			//Item ??? ????????????
//		case("/ItemInfoUpdate.do"): 
//			command = new ItemInfoUpdateCommand();
//			command.execute(request, response, session);	
//			int i_num1 = (int) request.getAttribute("result");
//			if(i_num1 != 0) {
//				viewPage = "ContentViewItems.do?i_num=" + i_num1;
//			}else {
//				return;
//			}
//		break;
//		
//		
//		//notice ?????? ??? ??????
//		
//		//notice ??? ???
//		case("/NoticeView.do"): 	
//			viewPage = "NoticeView.jsp";
//		break;
//		
//		//notice ??? ????????????
//		case("/NoticeInsert.do"): 
//			command = new NoticeInsertCommand();
//			command.execute(request, response, session);	
//			int n_num = (int) request.getAttribute("result");
//			if(n_num != 0) {
//				viewPage = "ContentViewNotices.do?n_num=" + n_num;
//			}else {
//				return;
//			}
//			break;
//			
//		case ("/ContentViewNotices.do"): // ????????? ~~.do??????
//			command = new ContentNoticeCommand(); // ?????????(?????????)??????
//			command.execute(request, response, session);
//			viewPage = "NoticeResultView.jsp"; // ????????? jsp??????
//			break;
//		
//		//notice ??? ????????????
//		case("/NoticeContent.do"): 
//			command = new NoticeContentCommand();
//			command.execute(request, response, session);	
//			viewPage = "NoticeUpdate.jsp";
//		break;
//		
//		//notice ??? ????????????
//		case("/NoticeUpdate.do"): 
//			command = new NoticeUpdateCommand();
//			command.execute(request, response, session);	
//			command.execute(request, response, session);	
//			int n_num1 = (int) request.getAttribute("result");
//			if(n_num1 != 0) {
//				viewPage = "ContentViewNotices.do?n_num=" + n_num1;
//			}else {
//				return;
//			}
//			break;
//
//
//		//?????? ????????? ??????;
//		// ???????????? ?????? ??????
//		case("/userProfile.do"):
//			command = new LoadUsersItem();
//			command.execute(request, response, session);
//			viewPage = "UserPageWithItem.jsp";
//		break;
//
//		case("/userOnlyItem.do"):
//			command = new LoadUsersItem();
//			command.execute(request, response, session);
//			viewPage = "UserPageWithItem.jsp";
//		break;
//		
//		case("/userOnlyTip.do"):
//			command = new LoadUsersTip();
//			command.execute(request, response, session);
//			viewPage = "UserPageWithTip.jsp";
//		break;
//		
//		// ??????????????? ??????
//		
//		//???????????????
//		case("/ComItem.do"):
//			session.setAttribute("postsCount", 1);
//			command = new LoadComItemCommand();
//			command.execute(request, response, session);
//			viewPage = "ListItem.jsp";
//		break;
//		
//		case("/AccItem.do"):
//			session.setAttribute("postsCount", 1);
//			command = new LoadAccItemCommand();
//			command.execute(request, response, session);
//			viewPage = "ListItem.jsp";
//		break;
//		
//		case("/DeskItem.do"):
//			session.setAttribute("postsCount", 1);
//			command = new LoadDeskItemCommand();
//			command.execute(request, response, session);
//			viewPage = "ListItem.jsp";
//		break;
//		
//		case("/OtherItem.do"):
//			session.setAttribute("postsCount", 1);
//			command = new LoadOtherItemCommand();
//			command.execute(request, response, session);
//			viewPage = "ListItem.jsp";
//		break;
//		
//		case("/CodeTip.do"):
//			session.setAttribute("postsCount", 1);
//			command = new LoadCodeTipCommand();
//			command.execute(request, response, session);
//			viewPage = "ListTIp.jsp";
//		break;
//		
//		case("/ProtoTip.do"):
//			session.setAttribute("postsCount", 1);
//			command = new LoadProtoTipCommand();
//			command.execute(request, response, session);
//			viewPage = "ListTIp.jsp";
//			break;
//		
//		case("/InfoTip.do"):
//			session.setAttribute("postsCount", 1);
//			command = new LoadInfoTipCommand();
//			command.execute(request, response, session);
//			viewPage = "ListTIp.jsp";
//			break;
//			
//		case("/OtherTip.do"):
//			session.setAttribute("postsCount", 1);
//			command = new LoadOtherTipCommand();
//			command.execute(request, response, session);
//			viewPage = "ListTIp.jsp";
//			break;
//		//---------------------------2021.05.27 ??????
//		case("/editView.do"):
//			command = new EditProfileViewCommand();
//			command.execute(request, response, session);
//			viewPage = "EditProfile.jsp";
//			break;
//			
//		//???????????? ??????
//		case("/edit.do"):
//			command = new EditProfileCommand();
//			command.execute(request, response, session);
//			viewPage = "infoedit.do";
//			break;
//		
//		case("/infoedit.do"):
//			command = new EditProfileViewCommand();
//			command.execute(request, response, session);
//		viewPage = "EditProfileEditSuccess.jsp";
//		break;
//		
//		//?????? ??????
//		case("/changePassword.do"):
//			command = new ChangePasswordCommand();
//			command.execute(request, response, session);
//			viewPage = "pwd.do";
//		break;
//		
//		case("/pwd.do"):
//			command = new EditProfileViewCommand();
//			command.execute(request, response, session);
//			viewPage = "EditProfilePwdSuccess.jsp";
//		break;
//		
//		//??????	
//		case("/deleteAccount.do"):
//			command = new DeleteAccountCommand();
//			command.execute(request, response, session);
//			viewPage = "LoginNowWithdraw.jsp";
//		break;
		}		

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}//---------------

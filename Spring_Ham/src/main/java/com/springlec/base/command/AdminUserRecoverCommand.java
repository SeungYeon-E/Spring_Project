package com.springlec.base.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base.dao.AdminUserDao;

public class AdminUserRecoverCommand implements Command {

	@Override
	public void execute(Model model, HttpSession httpSession, SqlSession sqlSession) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String user_email =request.getParameter("user_email");
		
		AdminUserDao dao = sqlSession.getMapper(AdminUserDao.class);
		
		int result = dao.userRecover(user_email);
		String result1 = "false";
		
		if(result == 0){
			result1 = "false";
		}else {
			result1 = "true";
		}
		
//		request.setAttribute("result", result);
		model.addAttribute("result", result1);
	}

}

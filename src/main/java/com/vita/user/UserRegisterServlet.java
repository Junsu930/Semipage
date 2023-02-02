package com.vita.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd"); 
		String userPwd2 = request.getParameter("userPwd2");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		
		if(userId == null || userId.equals("") || userPwd == null || userPwd.equals("") || userPwd2 == null || userPwd2.equals("") ||
		   userName == null || userName.equals("") || userPhone == null || userPhone.equals("") ) {
			request.getSession().setAttribute("messageType", "오류 메세지");
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요");
			response.sendRedirect("index.jsp");
			return;
		}
		
		
		if(!userPwd.equals(userPwd2)) {
			request.getSession().setAttribute("messageType", "오류 메세지");
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요");
			response.sendRedirect("index.jsp");
			return;
		}
		
		int result = new UserDAO().register(userId, userPwd,userName, userPhone);
		if(result == 1 ) {
			request.getSession().setAttribute("messageType", "성공 메세지");
			request.getSession().setAttribute("messageContent", "회원 가입에 성공했습니다.");
			response.sendRedirect("index.jsp");
			return;
		}else {
			request.getSession().setAttribute("messageType", "실패 메세지");
			request.getSession().setAttribute("messageContent", "회원 가입에 실패했습니다.");
			response.sendRedirect("index.jsp");
			return;
		}
		
		
	}
	

}

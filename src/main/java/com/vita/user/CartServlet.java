package com.vita.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String param = (String)request.getParameter("param");
		int parameter = Integer.parseInt(param);
		
		TestDAO dao = new TestDAO();
		TestDTO dto = dao.test(parameter);

		
		String json = "\"name\":\"" + dto.getProductName() + "\", \"price\":\"" + dto.getPrice() +"\", \"detail\" : \""+ dto.getProductDatail() + "\"";
		System.out.println(json);
		
		PrintWriter writer = response.getWriter();
		
		
	}

}

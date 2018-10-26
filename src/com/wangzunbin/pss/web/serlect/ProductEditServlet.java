package com.wangzunbin.pss.web.serlect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pro/edit")
public class ProductEditServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9046922736770925461L;
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	/*	RequestDispatcher dispatcher = arg0.getRequestDispatcher("/edit.jsp");
		dispatcher.forward(arg0, arg1);*/
	}
}

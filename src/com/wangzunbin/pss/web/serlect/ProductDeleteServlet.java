package com.wangzunbin.pss.web.serlect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;
import com.wangzunbin.pss.dao.IProductDAO;
import com.wangzunbin.pss.dao.impl.ProductDAOImpl;
import com.wangzunbin.pss.util.StringUtil;


@WebServlet("/pro/del")
public class ProductDeleteServlet extends HttpServlet {
	private IProductDAO dao = new ProductDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -5244377537655649378L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			if (StringUtil.hasLength(id)) {
				dao.delete(Long.valueOf(id));
			}
			// 控制页面跳转
			resp.sendRedirect("/pro/list");
	}
}

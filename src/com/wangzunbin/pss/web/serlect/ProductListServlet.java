package com.wangzunbin.pss.web.serlect;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangzunbin.pss.dao.IProductDAO;
import com.wangzunbin.pss.dao.impl.ProductDAOImpl;
import com.wangzunbin.pss.domain.Product;

@WebServlet("/pro/list")
public class ProductListServlet extends HttpServlet {

	private IProductDAO dao = new ProductDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -1464249059090584485L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list = dao.list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}
}

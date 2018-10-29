package com.wangzunbin.pss.web.serlect;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangzunbin.pss.dao.IProductDAO;
import com.wangzunbin.pss.dao.impl.ProductDAOImpl;
import com.wangzunbin.pss.domain.Product;

@WebServlet("/pro/save")
public class StudentSaveServelt extends HttpServlet {

	private IProductDAO dao = new ProductDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 5552004342660120725L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String salePrice = req.getParameter("salePrice");
		String supplier = req.getParameter("supplier");
		String brand = req.getParameter("brand");
		String cutoff = req.getParameter("cutoff");
		String costPrice = req.getParameter("costPrice");
		Product product = new Product(Long.valueOf(id), productName, Long.parseLong(dir_id), new BigDecimal(dir_id), 
				supplier, brand, Double.parseDouble(cutoff), new BigDecimal(costPrice));
		if (Objects.isNull(id)) {
			dao.save(product);
		} else {
			dao.update(product, Long.parseLong(id));
		}
		resp.sendRedirect("/pro/list");
		
	}
}

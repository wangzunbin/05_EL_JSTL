package com.wangzunbin.pss.web.serlect;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangzunbin.pss.dao.IProductDAO;
import com.wangzunbin.pss.dao.impl.ProductDAOImpl;
import com.wangzunbin.pss.domain.Product;
import com.wangzunbin.pss.util.StringUtil;

/**
 * 合并增删改查的代码
 * @author Administrator
 *
 */
@WebServlet("/product")
public class StudentServlet extends HttpServlet{

	private IProductDAO dao = new ProductDAOImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8172603455619840277L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmd = req.getParameter("cmd");
		if ("edit".equals(cmd)) {
			edit(req, resp);
		} else if ("delete".equals(cmd)) {
			delete(req, resp);
		} else if ("saveOrUpdate".equals(cmd)) {
			saveOrUpdate(req, resp);
		} else {
			list(req, resp);
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		List<Product> list = dao.list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
		
	}

	private void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String salePrice = req.getParameter("salePrice");
		String supplier = req.getParameter("supplier");
		String brand = req.getParameter("brand");
		String cutoff = req.getParameter("cutoff");
		String costPrice = req.getParameter("costPrice");
//		System.out.println(StringUtil.hasLength(id) + id + "daja");
		Product product = new Product(!StringUtil.hasLength(id)?null:Long.valueOf(id), 
				productName,
				Long.parseLong(dir_id),
				new BigDecimal(salePrice), 
				supplier,
				brand,
				Double.parseDouble(cutoff), 
				new BigDecimal(costPrice));
		if (!StringUtil.hasLength(id)) {
			dao.save(product);
		} else {
			dao.update(product, Long.parseLong(id));
		}
		resp.sendRedirect("/pro/list");
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		if (StringUtil.hasLength(id)) {
			dao.delete(Long.valueOf(id));
		}
		resp.sendRedirect("/pro/list");
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (StringUtil.hasLength(id)) {
			Product product = dao.get(Long.valueOf(id));
			req.setAttribute("pro", product);
		}
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
	}
}

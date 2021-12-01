package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DaoFactory;
import model.Department;
import model.Seller;
import model.SellerDao;

@WebServlet("/sellerFindByDepartment")
public class SellerFindByDepartmentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	SellerDao dao = DaoFactory.createSellerDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		Integer departId = Integer.parseInt(req.getParameter("idDepart"));
		List<Seller> sellers = dao.findByDepartment(new Department(departId, null));
		
		req.setAttribute("sellerstAttr", sellers);

		RequestDispatcher disp = req.getRequestDispatcher("ListAllSellersByDepartment.jsp");
		
		disp.forward(req, resp);
	}

}

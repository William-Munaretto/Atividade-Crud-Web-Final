package controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/sellerFindAll")
public class SellerFindAllServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	SellerDao dao = DaoFactory.createSellerDao();
	private List<Seller> sellers = new ArrayList<Seller>();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String listar = req.getParameter("idFindAll");
		
		if(listar.equals("Listar-todos")) {
			sellers = dao.findAll();
			req.setAttribute("listSellertAttr", sellers);

			RequestDispatcher disp = req.getRequestDispatcher("listAllSellers.jsp");
			
			disp.forward(req, resp);
		}
	}

}

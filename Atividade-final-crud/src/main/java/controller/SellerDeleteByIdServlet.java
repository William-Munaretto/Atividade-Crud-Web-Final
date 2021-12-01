package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoFactory;
import model.SellerDao;

@WebServlet("/sellerDelete")
public class SellerDeleteByIdServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	SellerDao dao = DaoFactory.createSellerDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("IdDeleteSeller"));
		dao.deleteById(id);
		
	}
}

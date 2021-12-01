package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.DaoFactory;
import model.Department;
import model.DepartmentDao;
import model.Seller;
import model.SellerDao;

@WebServlet("/sellerInsert")
public class SellerInsertServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	SellerDao dao = DaoFactory.createSellerDao();
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	DepartmentDao dao1 = DaoFactory.createDepartmentDao();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String nomeParam = req.getParameter("nomeInsert");
			String mailParam = req.getParameter("mailInsert");
			String dateParam = req.getParameter("dataInsert");
			Double BaseSalaryParam = Double.parseDouble(req.getParameter("SalaryInsert"));
			Integer departIdParam = Integer.parseInt(req.getParameter("DepartmentId"));
			

			Department d = new Department();
			d = dao1.findById(departIdParam);
			
			System.out.println(d.getId());
			
			Seller s = new Seller();
			s.setName(nomeParam);
			s.setEmail(mailParam);
			s.setBirthdate(Date.valueOf(dateParam));
			s.setBaseSalary(BaseSalaryParam);
			s.setDepartment(d);
			
			try {
				dao.insert(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String msg = "Cadastro realizado com sucesso!!";		
			req.setAttribute("msgInserSellertAttr",msg);
				
			RequestDispatcher disp = req.getRequestDispatcher("seller.jsp");
				
			disp.forward(req, resp);
		
	}
}

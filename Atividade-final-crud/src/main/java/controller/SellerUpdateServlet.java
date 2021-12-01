package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoFactory;
import model.Department;
import model.DepartmentDao;
import model.Seller;
import model.SellerDao;

@WebServlet("/sellerUpdate")
public class SellerUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	SellerDao dao = DaoFactory.createSellerDao();
	DepartmentDao dao1 = DaoFactory.createDepartmentDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			Integer idParam = Integer.parseInt(req.getParameter("idUpdate"));
			String nomeParam = req.getParameter("nomeUpdate");
			String mailParam = req.getParameter("mailUpdate");
			String dateParam = req.getParameter("dataUpdate");
			Double BaseSalaryParam = Double.parseDouble(req.getParameter("SalaryUpdate"));
			Integer departIdParam = Integer.parseInt(req.getParameter("DepartmentIdUpdate"));
			
			
			System.out.println(dateParam);
			Department d1 = new Department();
			d1.setId(departIdParam);
			
			Seller s3 = new Seller();
			
			s3.setName(nomeParam);
			s3.setEmail(mailParam);
			s3.setBirthdate(Date.valueOf(dateParam));
			s3.setBaseSalary(BaseSalaryParam);
			s3.setDepartment(d1);
			s3.setId(idParam);
			
			dao.update(s3);
			
			String msg = "Cadastro atualizado com sucesso!!";		
			req.setAttribute("msgUpdateSellertAttr",msg);
				
			RequestDispatcher disp = req.getRequestDispatcher("seller.jsp");
				
			disp.forward(req, resp);
		
	}

}

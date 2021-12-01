package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoFactory;
import model.Department;
import model.DepartmentDao;

@WebServlet("/departmentInsert")
public class DepartInsertServlet extends HttpServlet {

	
		//DepartmentDaoJDBC dao = new DepartmentDaoJDBC(ConnectionFactory.getConnection());
		DepartmentDao dao = DaoFactory.createDepartmentDao();
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//insert
			 String nomeInsert = req.getParameter("nomeInsert");
			 Department d = new Department();
			 d.setName(nomeInsert);
			 dao.insert(d);
			 
			 String msg = "Cadastro realizado com sucesso!!";		
			 req.setAttribute("msgInserDepartAttr",msg);
				
			 RequestDispatcher disp = req.getRequestDispatcher("department.jsp");
				
			 disp.forward(req, resp);
			 
			 
			 
		}
			
}



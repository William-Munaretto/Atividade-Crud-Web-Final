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
@WebServlet("/departmentUpdate")
public class DepartUpdateServlet extends HttpServlet {

		DepartmentDao dao = DaoFactory.createDepartmentDao();
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//update
			String nomeUpdateParam = req.getParameter("nomeUpdate");
			Integer idUpdateParam = Integer.parseInt(req.getParameter("IdUpdate"));
			Department d1 = new Department();
			d1.setId(idUpdateParam);
			d1.setName(nomeUpdateParam);
			dao.update(d1);
			
		
			String msg = "Update realizado com sucesso!!";		
			req.setAttribute("msgUpdateAttr",msg);
			
			RequestDispatcher disp = req.getRequestDispatcher("department.jsp");
			
			disp.forward(req, resp);
		}
}			


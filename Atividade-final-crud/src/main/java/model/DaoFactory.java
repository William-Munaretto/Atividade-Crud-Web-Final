package model;

import connection.ConnectionFactory;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		
		SellerDao dao = new SellerDaoJDBC(ConnectionFactory.getConnection());
		
		return dao;
		
	}
	
	public static DepartmentDao createDepartmentDao() {
		
		DepartmentDao dao = new DepartmentDaoJDBC(ConnectionFactory.getConnection());
		
		return dao;
		
	}

}

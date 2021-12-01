package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import exception.DatabaseException;


public class SellerDaoJDBC implements SellerDao {
	

		private Connection connection;
		
		public SellerDaoJDBC(Connection connection) {
			this.connection = connection;
		}
		
		@Override
		public void insert(Seller seller) throws ParseException {
			Connection conn = ConnectionFactory.getConnection();
			
			try {
				
			PreparedStatement st = conn.prepareStatement(""
					+ "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
			st.setString(1, seller.getName());
			st.setString(2, seller.getEmail());
			st.setDate(3, (Date) seller.getBirthdate());
			st.setDouble(4, seller.getBaseSalary());
			st.setInt(5, seller.getDepartment().getId());
			
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("linhas afetadas: " + rowsAffected);
			
			//Obter os ids ou id inseridos
			ResultSet ids = st.getGeneratedKeys();
			
			ids.next();
			Integer id = ids.getInt(1);
			
			System.out.println("O id inserido foi: " + id);
			
			
			}catch(SQLException e1) {
				throw new DatabaseException(e1.getMessage());
			}
		}

		@Override
		public void update(Seller seller) {
			Connection conn = ConnectionFactory.getConnection();
			try {
				
				conn.setAutoCommit(false);
				PreparedStatement st = conn.prepareStatement("UPDATE seller SET Name = ?, Email = ?, Birthdate = ?, BaseSalary = ?, DepartmentId = ? WHERE id = ?");
				
			
				st.setString(1, seller.getName());
				st.setString(2, seller.getEmail());
				st.setDate(3, (Date) seller.getBirthdate());
				st.setDouble(4, seller.getBaseSalary());
				st.setInt(5, seller.getDepartment().getId());
				st.setInt(6, seller.getId());
				
				int rowsAffected = st.executeUpdate();
				
				System.out.println("linhas afetadas: " + rowsAffected);
				
				conn.commit();
			
			}catch(SQLException e1) {
				try {
					conn.rollback();
					throw new DatabaseException("problema de transacao");
				
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
		}

		@Override
		public void deleteById(Integer id) {
			Connection conn = ConnectionFactory.getConnection();
			
			try {
				
				PreparedStatement st = conn.prepareStatement(""
						+ "DELETE FROM seller WHERE Id = ?");
			
				st.setInt(1, id);
				
				int rowsAffected = st.executeUpdate();
				
				System.out.println("linhas afetadas: " + rowsAffected);
			
			
			} catch (SQLException e) {
				
				throw new DatabaseException(e.getMessage());
				
			}
		}

		@Override
		public Seller findById(Integer id) {
			PreparedStatement statement = null;
			ResultSet result = null;
			
			try {
				
				String sql = "SELECT seller.*, department.Name as DepName "
						+ "FROM seller "
						+ "INNER JOIN department "
						+ "ON seller.DepartmentId = department.Id "
						+ "WHERE seller.Id = ?";
				
				statement = connection.prepareStatement(sql);
				
				statement.setInt(1, id);
				
				result = statement.executeQuery();
				
				if(result.next()){
					Department dp = new Department();
					dp.setId(result.getInt("Id"));
					dp.setName(result.getString("Name"));
					
					Seller seller = new Seller();
					seller.setId(result.getInt("Id"));
					seller.setName(result.getString("Name"));
					seller.setEmail(result.getString("Email"));
					seller.setBirthdate(result.getDate("BirthDate"));
					seller.setBaseSalary(result.getDouble("BaseSalary"));
					
					//passa um objeto tipo Department
					seller.setDepartment(dp);
					
					return seller;
				}
				
			}catch(SQLException e1) {
				throw new DatabaseException(e1.getMessage());
			}finally {
				ConnectionFactory.closeStatement(statement);
				ConnectionFactory.closeResultSet(result);
			}
			
			return null;
			
		}

		@Override
		public List<Seller> findAll() {
			PreparedStatement statement = null;
			ResultSet result = null;
			List<Seller> resultado = new ArrayList<Seller>();
			try {
				String sql = "SElECT * FROM seller";
				
				statement = connection.prepareStatement(sql);
				result = statement.executeQuery();
				
				while(result.next()) {
					
					Seller s = new Seller();
					s.setId(result.getInt("Id"));
					s.setName(result.getString("Name"));
					s.setEmail(result.getString("Email"));
					s.setBirthdate(result.getDate("BirthDate"));
					s.setBaseSalary(result.getDouble("BaseSalary"));
					resultado.add(s);
				}
				
				return resultado;
				
			}catch(SQLException e1) {
				throw new DatabaseException(e1.getMessage());
			}finally {
				ConnectionFactory.closeStatement(statement);
				ConnectionFactory.closeResultSet(result);
			}
			
			
		}

		@Override
		public List<Seller> findByDepartment(Department dep) {
			
			PreparedStatement statement = null;
			ResultSet result = null;
			List<Seller> sellers = new ArrayList<Seller>();
			
			try {
				
				String sql = "SELECT seller.*,department.Name as DepName FROM seller\n" + 
						"INNER JOIN department ON seller.DepartmentId =\n" + 
						"department.Id WHERE DepartmentId = ? ORDER BY Name";
				
				statement = connection.prepareStatement(sql);
				
				//set o primeiro parâmetro do SQL = "?"
				statement.setInt(1, dep.getId());
				
				result = statement.executeQuery();
				
				while(result.next()){
					
					Department department = createDepartment(result);
					
					Seller seller = createSeller(result, department);
					
					sellers.add(seller);
				}
				
				return sellers;
				
			}catch(SQLException e1) {
				throw new DatabaseException(e1.getMessage());
			}
			
		
			
		}
		
		
		private Seller createSeller(ResultSet result, Department depart) throws SQLException {
			
			Seller seller = new Seller();
			seller.setId(result.getInt("Id"));
			seller.setName(result.getString("Name"));
			seller.setEmail(result.getString("Email"));
			seller.setBirthdate(result.getDate("BirthDate"));
			seller.setBaseSalary(result.getDouble("BaseSalary"));
			
			//passa um objeto tipo Department
			seller.setDepartment(depart);
			
			return seller;
		}
		
		private Department createDepartment(ResultSet result) throws SQLException {
			Department dp = new Department();
			dp.setId(result.getInt("Id"));
			dp.setName(result.getString("Name"));
			return dp;
		}

}




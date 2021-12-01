package model;

import java.text.ParseException;
import java.util.List;

public interface SellerDao {
	
	public void insert(Seller seller) throws ParseException;
	
	public void update(Seller seller);
	
	public void deleteById(Integer id);
	
	public Seller findById(Integer id);
	
	public List<Seller> findAll();
	
	public List<Seller> findByDepartment(Department dep);


}

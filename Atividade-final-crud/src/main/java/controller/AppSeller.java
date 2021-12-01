package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import connection.ConnectionFactory;
import model.SellerDao;
import model.Department;
import model.Seller;
import model.SellerDaoJDBC;

public class AppSeller {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao dao = new SellerDaoJDBC(ConnectionFactory.getConnection());
		Scanner scanner = null;
		
//		public static void main(String[] args) throws ParseException {
//			
//			AppSeller ap = new AppSeller();
//			ap.menu();
//			
//		}
//		
//		
//		public void menu() throws ParseException{
//			int opcao = -1;
//			Scanner scanner = new Scanner(System.in);
//			while(opcao != 0){
//				System.out.println("\n--------------------------------------------------------------");
//				System.out.println("CRUD SELLER:");
//				System.out.println("[1] Insert");
//				System.out.println("[2] Update");
//				System.out.println("[3] DeleteById");
//				System.out.println("[4] FindById");
//				System.out.println("[5] FindAll");
//				System.out.println("[6] FindByDeparment");
//				System.out.println("[0] Voltar ao menu principal.");
//				System.out.println("\n--------------------------------------------------------------");
//				try{
//					opcao = Integer.parseInt(scanner.nextLine());	
//				} catch (Exception e) {
//					System.out.println("Erro... informe um numero inteiro");
//				}			
//
//				if(opcao == 1){
//					this.insert();
//				}else if(opcao == 2){
//					this.update();			
//				}else if(opcao == 3){
//					this.delete();
//				}else if(opcao == 4){
//					this.findById();
//				}else if(opcao == 5){
//					this.findAll();
//				}else if(opcao == 6){
//					this.findByDepartment();	
//				}else if(opcao != 0){
//					System.out.println("Opcao invalida!");
//				}
//			}
//		}
//		
//		public void insert() throws ParseException {
//			System.out.println("======= TESTE 1 (INSERT) ============");
//			Department d = new Department();
//			d.setId(1);
//			
//			Seller s2 = new Seller();
//			s2.setName("João");
//			s2.setEmail("joao@joao.com.br");
//			s2.setBirthdate( new java.sql.Date(dateFormat.parse("26/04/1989").getTime()));
//			s2.setBaseSalary(1200.00);
//			s2.setDepartment(d);
//			
//			dao.insert(s2);
//		}
//		
//		public void update() throws ParseException {
//			System.out.println("======= TESTE 2 (UPDATE) ============");
//			Department d1 = new Department();
//			d1.setId(2);
//			
//			Seller s3 = new Seller();
//			
//			s3.setName("Marcelo");
//			s3.setEmail("marcelo@ifpr.com.br");
//			s3.setBirthdate( new java.sql.Date(dateFormat.parse("26/04/1990").getTime()));
//			s3.setBaseSalary(11000.00);
//			s3.setDepartment(d1);
//			s3.setId(4);
//			
//			dao.update(s3);
//		}
//		
//		public void delete() {
//			System.out.println("======= TESTE 3 (DELETE) ============");
//			dao.deleteById(6);
//		}
//		
//		public void findById() {
//			System.out.println("======= TESTE4 (findById)  ============");
//			Seller seller = dao.findById(2);
//			System.out.println(seller);
//		}
//		
//		public void findAll() {
//			System.out.println("======= TESTE5 (findAll)  ============");
//			List<Seller> s5 = dao.findAll();
//			for (Seller s : s5) {
//				System.out.println(s);
//			}
//		}
//		
//		public void findByDepartment() {
//			System.out.println("======= TESTE 6 (findByDepartment) ============");
//			List<Seller> sellers = dao.findByDepartment(new Department(1, null));
//			for (Seller s : sellers) {
//				System.out.println(s);
//			}
//		}
}

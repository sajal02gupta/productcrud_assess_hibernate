package dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.ProductDao;
import model.Product;

public class Main {
	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scn= new Scanner(System.in);
			System.out.println("1. Enter Product Details");
			System.out.println("2. Update the Product Details");
			System.out.println("3. Delete the product");
			System.out.println("4. View all the products");
			
			int opt= scn.nextInt();
			switch (opt) {
			case 1:
				Scanner scn1= new Scanner(System.in);
				System.out.println("Enter the Product Name");
				String name=scn1.nextLine();
				System.out.println("Enter the product description");
				String description= scn1.nextLine();
				System.out.println("Enter the product price");
				String price=scn1.nextLine();
				System.out.println("Enter the product quantity");
				String quantity=scn1.nextLine();
				
				int pr = Integer.parseInt(price);
				int quant = Integer.parseInt(quantity);
				
				Product p=new Product(name, description,pr, quant);
				ProductDao pDao= new ProductDao();
				pDao.create(p);
				
				System.out.println("Product created..");
				break;
			case 2:
				System.out.println("Enter the ID");
				long id= scn.nextLong();
				scn.nextLine();
				System.out.println("Enter the updated Product Name");
				String updatedname=scn.nextLine();
				System.out.println("Enter the updated product description");
				String updateddescription= scn.nextLine();
				System.out.println("Enter the updated product price");
				String updatedprice=scn.nextLine();
				System.out.println("Enter the updated product quantity");
				String updatedquantity=scn.nextLine();
				//long val= Long.parseLong(id);
				int updatedpr = Integer.parseInt(updatedprice);
				int updatedquant = Integer.parseInt(updatedquantity);
				
				ProductDao pDao1= new ProductDao();
				pDao1.update(id,updatedname, updateddescription,updatedpr, updatedquant);
				System.out.println("Updated");
				break;
			case 3:
				System.out.println("Enter the ID");
				Scanner sc= new Scanner(System.in);
				long id1= sc.nextLong();
				ProductDao pDao2= new ProductDao();
				pDao2.delete(id1);
				System.out.println("Deleted");
				break;
			case 4:
				ProductDao p4= new ProductDao();
				List<Product> product= p4.findAll();
				for (Product product2 : product) {
					System.out.println(product2.getName()+" "+product2.getDescription()+" "+product2.getPrice()+" "+product2.getQuantity()+" " );
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
	}

}

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	private int price;
	private int quantity;
	
	public Product(){}
	
	public Product(String b, String c, int d, int e){
		this.name=b;
		this.description=c;
		this.price=d;
		this.quantity=e;
	}
	public Product(long a, String b, String c, int d, int e){
		this.id=a;
		this.name=b;
		this.description=c;
		this.price=d;
		this.quantity=e;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
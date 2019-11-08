package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Product;


public class ProductDao {
	private EntityManagerFactory entityManagerFactory;

	public void create(Product p) {

		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();
	}
	public Product update(long id, String name,String desc,int price,int quantity) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();
		EntityManager em=entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Product p=em.find(Product.class, id);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setDescription(desc);
		em.getTransaction().commit();
		return p;
	}
	
	public void delete(long id) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(em.find(Product.class, id));
		
		em.getTransaction().commit();
	}
	public List<Product> findAll() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		List<Product> products = em.createQuery("select s from Product s", Product.class).getResultList();

		return products;
	}
}

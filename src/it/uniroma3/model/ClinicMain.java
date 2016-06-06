package it.uniroma3.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class ClinicMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("typology-unit");
		EntityManager em = emf.createEntityManager();
		
		ExamTypology type = new ExamTypology();
		ExamTypology type2 = new ExamTypology("Cardiologico", "CARDGV170516", "Esame cardiologico", 300.2F);
		type.setName("Cardiologico");
		type.setCode("CARDGV170516");
		type.setDescription("Esame cardiologico");
		type.setCost(300.2F);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try { 
			em.persist(type);
			tx.commit();
		}
		catch (Exception e) {
			System.out.println("Mah");
		}
		try {
			em.persist(type2);
			tx.commit();
		}
		catch (Exception e) {
			System.out.println("Meh");
		}
		try {
			tx.commit();
		}
		catch (Exception e) {
			System.out.println("Bah");
		}
		finally {
			em.close();
			emf.close();
		}
	}
}

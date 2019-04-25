package com.hibernate.activity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CompanyMain {
	public static void main(String[] args) {
		System.out.println("Intializing session Factory.......");
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Company.class)
				.buildSessionFactory();
		System.out.println("SessionFactory created and getting current session...");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session created....");
		try {
			System.out.println("Compnay Object creation.....");
//
//			Company company = new Company("Jon", "King", "North");
//			Company company1 = new Company("Sansa", "Sister", "North");
//			Company company2 = new Company("Arya", "Younger Sister", "North");
//			Company company3 = new Company("Daenrys", "Queen", "South");
//			Company company4 = new Company("Cersei", "Bitcg", "South");
//
//			System.out.println("Beginning Transaction.....");
			session.beginTransaction();
//			System.out.println("Company Object " + company);
//			System.out.println("Company Object " + company1);
//			System.out.println("Company Object " + company2);
//			System.out.println("Company Object " + company3);
//			System.out.println("Company Object " + company4);
//
//			System.out.println("Saving the values");
//			session.save(company);
//			session.save(company1);
//			session.save(company2);
//			session.save(company3);
//			session.save(company4);
//
//			System.out.println("Object Saved");
//			System.out.println("Transaction Done");
//
//			// Retreive the object
//			
//
//			Company company5 = session.get(Company.class, company.getId());
//			Company company6 = session.get(Company.class, company1.getId());
//			Company company7 = session.get(Company.class, company2.getId());
//			Company company8 = session.get(Company.class, company3.getId());
//			Company company9 = session.get(Company.class, company4.getId());
//			System.out.println(company5);
//			System.out.println(company6);
//			System.out.println(company7);
//			System.out.println(company8);
//			System.out.println(company9);

			List<Company> list = session.createQuery("from Company").getResultList();
			displayMethod(list);
			
			list = session.createQuery("from Company c where c.companyName='North'").getResultList();
			displayMethod(list);
			
//			int id=4;
//			Company company = session.get(Company.class, id);
//			session.delete(company);
//			session.getTransaction().commit();
			
//			int id1=5;
//			Company company2 = session.get(Company.class, id1);
//			company2.setEmployeeName("Cersei1");
			
			session.createQuery("update Company set employeeName='Cersei' where id=5").executeUpdate();
			
			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static void displayMethod(List<Company> list) {
		for (Company company : list) {
			System.out.println("Company List " + company);
		}
	}

}

package com.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMain {
	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = sessionFactory.getCurrentSession();
		try {

			// create Student object
			Student student = new Student("Subu", "r", "rsubu110@gamil.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving the student");
			session.save(student);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Transaction Done");

		} finally {
			sessionFactory.close();
		}
	}

}

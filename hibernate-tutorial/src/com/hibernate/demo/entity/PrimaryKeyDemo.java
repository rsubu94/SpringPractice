package com.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Student student4 = new Student("Subu", "R", "rsubu110@gmail.com");
			Student student = new Student("Praveen", "S", "s_praveen@gamil.com");
			Student student1 = new Student("Naren", "M", "naren@gamil.com");
			Student student2 = new Student("Oly", "R", "oly@gamil.com");

			session.beginTransaction();

			System.out.println("Saving the students");
			session.save(student);
			session.save(student1);
			session.save(student2);
			System.out.println("Saved");

			session.getTransaction().commit();
			System.out.println("Transaction Done");

		} finally {
			sessionFactory.close();
		}

	}

}

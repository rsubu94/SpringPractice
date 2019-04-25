package com.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
//			int id = 2;
//			session.beginTransaction();
//			Student student = session.get(Student.class, id);
//			session.delete(student);
//			session.getTransaction().commit();

			// NEW Code
			sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id='3'").executeUpdate();
			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}

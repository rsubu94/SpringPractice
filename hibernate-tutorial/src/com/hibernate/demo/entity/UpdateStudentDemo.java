package com.hibernate.demo.entity;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			int id = 2;

			session.beginTransaction();

			Student student = session.get(Student.class, id);
			student.setFirstName("Subu");

//			Query query = session.createQuery("update Student set s.email='email@gmail.com'").executeUpdate();

			session.getTransaction().commit();

			// NEW CODE
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			session.createQuery("update Student set email='email@gmail.com'").executeUpdate();
			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}

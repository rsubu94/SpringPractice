package com.hibernate.demo.entity;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotatedClassType;
import org.hibernate.cfg.Configuration;

public class QueryingData {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Student> list = session.createQuery("from Student").getResultList();
		System.err.println("***************!---1---!***************");
		displayStudnet(list);

		list = session.createQuery("from Student s where s.lastName='T'").getResultList();
		System.err.println("***************!---2---!***************");
		displayStudnet(list);

		list = session.createQuery("from Student s where s.lastName='R' OR s.firstName='Subu'").getResultList();
		System.err.println("***************!---3---!***************");
		displayStudnet(list);
		
		list = session.createQuery("from Student s where s.lastName LIKE 'S%'").getResultList();
		System.err.println("***************!---4---!***************");
		displayStudnet(list);
		
		list = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").getResultList();
		System.err.println("***************!---5---!***************");
		displayStudnet(list);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	private static void displayStudnet(List<Student> list) {
		Iterator<Student> iterator = list.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println("ID : " + student.getId());
			System.out.println("Firstname : " + student.getFirstName());
			System.out.println("Lastname : " + student.getLastName());
			System.out.println("Email : " + student.getEmail());
		}
	}

}

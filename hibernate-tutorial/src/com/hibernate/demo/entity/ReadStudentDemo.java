package com.hibernate.demo.entity;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Student student = new Student("Arun", "T", "arun@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

			// MY NEW CODE

			// find out the student's id:Primary key
			System.out.println("Get Id" + student.getId());

			// now get a new session ans start transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id:primary key
			System.out.println("Get Id II : " + student.getId());
			Student student2 = session.get(Student.class, student.getId());

			// commit the transaction
			System.out.println("Get Complete " + student2);
			System.out.println("Student Firstname" + student2.getFirstName());
			System.out.println("Student Lastname" + student2.getLastName());
			System.out.println("Student Email" + student2.getEmail());

			// retreive all data
			Query query = session.createQuery("from Student");
			List<Student> list = query.getResultList();
			System.out.println(list);

			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}

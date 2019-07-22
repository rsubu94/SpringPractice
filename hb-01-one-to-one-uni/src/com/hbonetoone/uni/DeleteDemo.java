package com.hbonetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).
				buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.beginTransaction();
			int id=6;
			Instructor teinstructor=session.get(Instructor.class, id);
			
			System.out.println("Found INstructor "+teinstructor);
			
			if(teinstructor!=null) {
				System.out.println("deleting instructor");
				session.delete(teinstructor);
			}
			
			session.getTransaction().commit();
		}
		catch(Exception e) {
			session.close();
			sessionFactory.close();
			
		}
		
	}
}

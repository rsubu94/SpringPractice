package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.onetomany.*;


public class CreateInstructorDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","code");
			Instructor instructor = new Instructor( "Subramanian", "R","rsubu@gmail.com" , instructorDetail);
			
			InstructorDetail instructorDetail1 = new InstructorDetail("http://youtube.com","code");
		Instructor instructor1 = new Instructor( "Narendran", "MC","naren@gmail.com" , instructorDetail1);
			session.beginTransaction();
			session.save(instructor);
			session.save(instructor1);

			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}

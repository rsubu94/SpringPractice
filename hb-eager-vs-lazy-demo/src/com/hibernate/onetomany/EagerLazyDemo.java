package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.onetomany.*;

public class EagerLazyDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {

			session.beginTransaction();

			// get the instructor from db
			int theId = 2;
			Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Stop Here :: Instructor : " + instructor);

			// get course for the instructor
			//option:1 call getter method while session is open
			System.out.println("Courses " + instructor.getCourses());
			//checking lazy loading fail

			session.getTransaction().commit();
			session.close();
			
			System.out.println("\n the session is closed\n");
			System.out.println("Courses " + instructor.getCourses());

			System.out.println("Done !!!!!");
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			sessionFactory.close();
		}
	}

}

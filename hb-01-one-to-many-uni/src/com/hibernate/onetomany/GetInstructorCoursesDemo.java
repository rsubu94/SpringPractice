package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.onetomany.*;

public class GetInstructorCoursesDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {

			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Instructor : " + instructor);

			// get course for the instructor
			System.out.println("Courses " + instructor.getCourses());

			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}

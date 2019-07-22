package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.onetomany.*;

public class DeleteCoursesDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {

			session.beginTransaction();

			// get a course
			int theId = 3;
			Course tempCourse = session.get(Course.class, theId);

			// delete a course
			session.delete(tempCourse);

			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}

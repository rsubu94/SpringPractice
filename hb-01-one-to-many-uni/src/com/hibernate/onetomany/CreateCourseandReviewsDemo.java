package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseandReviewsDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {

			session.beginTransaction();
			
			
			Course course = new Course("Java");
			
			course.add(new Review("Complete Course...111"));
			course.add(new Review("Complete Course...222"));
			course.add(new Review("Complete Course...3333"));
			
			session.saveOrUpdate(course);


			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}

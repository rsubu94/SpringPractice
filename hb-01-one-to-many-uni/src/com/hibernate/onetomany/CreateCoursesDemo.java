package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.onetomany.*;

public class CreateCoursesDemo {
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

			// create some courses
//			Course tempCourses = new Course("Air Guitar - The Ultimate Guide");
//			Course course = new Course("The Pinball Masterclass");
//
//			// add courses to instructor
//			instructor.add(tempCourses);
//			instructor.add(course);

			// save the courses
//			session.save(tempCourses);
//			session.save(course);
			instructor.getCourses().get(0).setInstructor(null);
			session.delete(instructor);

			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}

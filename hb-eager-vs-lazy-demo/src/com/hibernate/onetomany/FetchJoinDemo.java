package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.onetomany.*;

public class FetchJoinDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {

			session.beginTransaction();

			// get the instructor from db
			int theId = 2;

			Query<Instructor> query = session.
					createQuery("select j from Instructor j "
							+"JOIN FETCH j.courses "
							+"where j.id=:theInstructorId",Instructor.class);
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("INstructor "+instructor);
		
			session.getTransaction().commit();
			session.close();
			System.out.println("Now session Closed");
			System.out.println("Instructor detail "+instructor.getCourses());
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			sessionFactory.close();
		}
	}

}

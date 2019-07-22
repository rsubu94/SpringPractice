package com.hbonetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
//			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","code");
//			Instructor instructor = new Instructor( "Subramanian", "R","rsubu@gmail.com" , instructorDetail);
//			
//			InstructorDetail instructorDetail1 = new InstructorDetail("http://youtube.com","code");
//			Instructor instructor1 = new Instructor( "Narendran", "MC","naren@gmail.com" , instructorDetail1);
			session.beginTransaction();

			int theId = 6;
			InstructorDetail instructor = session.get(InstructorDetail.class, theId);
			System.out.println("INstructor " + instructor);
			System.err.println(instructor.getInstructor());
			
			System.out.println("Deleting the INstructor");
			
			
			//remove the associated object reference break bi-directional link
			instructor.getInstructor().setInstructorDetail(null);
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

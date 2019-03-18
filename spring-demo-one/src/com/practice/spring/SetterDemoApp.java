package com.practice.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
	public static void main(String[] args) {

		// Load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);

		// call methods on the bean
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		//call our new methods to get literals

		System.out.println(cricketCoach.getEmailAddress());
		System.out.println(cricketCoach.getTeam());

		// close the context
		context.close();
	}

}

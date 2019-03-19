package com.springannotation.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach coach = context.getBean("tennisCoach",TennisCoach.class);
		Coach coachNext = context.getBean("tennisCoach",TennisCoach.class);
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDailyWorkOut());
		System.out.println(coach==coachNext);
		System.out.println(coach);
		System.out.println(coachNext);
		context.close();
	}

}

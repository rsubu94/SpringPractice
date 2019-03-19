package com.springannotation.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDailyWorkOut());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		coach.setEmail("rsubu.mani");
		coach.setTeam("Munbai Indians");;
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());

		context.close();

	}

}

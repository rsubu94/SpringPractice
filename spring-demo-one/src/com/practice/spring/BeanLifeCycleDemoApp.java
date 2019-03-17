package com.practice.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		Coach coach = context.getBean("myCoach",Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}
}

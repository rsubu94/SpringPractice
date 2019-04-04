package com.spring.withoutxml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		Coach coach = context.getBean("tennisCoach", Coach.class);

		System.out.println(coach.getDailyWorkOut());

		context.close();
	}
}

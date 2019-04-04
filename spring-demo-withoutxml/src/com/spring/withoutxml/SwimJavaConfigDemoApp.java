package com.spring.withoutxml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SportConfig.class);
		SwimCoach coach=configApplicationContext.getBean("swimCoach",SwimCoach.class);
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDailyWorkOut());
		System.out.println("Email "+coach.getEmail());
		System.out.println("Team "+coach.getTeam());
		configApplicationContext.close();
		
	}

}

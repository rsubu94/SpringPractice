package com.springannotation.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		/*We can use default bean by using only @Component only in our class and use class name to retreive it 
		 * or use our own bean with the @Component("tennisCoach")*/
		
		Coach coach = context.getBean("tennisCoach", Coach.class);

		System.out.println(coach.getDailyWorkOut());

		context.close();
	}
}

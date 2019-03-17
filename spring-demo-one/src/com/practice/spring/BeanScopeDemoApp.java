package com.practice.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if both the bean are same
		System.out.println("Is bean equal : "+(theCoach==alphaCoach));
		
		System.out.println("\n Memory location for theCoach : "+theCoach);
		
		System.out.println("\n Memory location for alphaCoach : "+alphaCoach );
		
		context.close();
	}
}

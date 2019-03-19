package com.springannotation.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // @Component("tennisComponent")
@Scope("singleton")
public class TennisCoach implements Coach {

//	@Autowired
//	@Qualifier("RESTFortuneService")
	private FortuneService fortuneService;
	
	//@Value("${sport.email}")
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Value("${sport.team}")
	private String team;

	public TennisCoach() {
		System.out.println("TennisCoach : inside default constructor");
	}

//	@Autowired
//	public TennisCoach(@Qualifier("happyFortuneService")FortuneService fortuneService) {
//		super();
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkOut() {
		return "Daily practice backhand volley";
	}

	//SetterInjection
//	@Autowired
//	@Qualifier("databaseFortuneService")
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("Tennis Coach : SetFortuneService Method");
//		this.fortuneService = fortuneService;
//	}
	
	//Method Injection
	@Autowired
	@Qualifier("randomFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("Tennis Coach : doSomeCrazyStuff");
		this.fortuneService = fortuneService;
	}

	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
	
	//Bean Lifecycle in Annotation
	@PostConstruct
	public void startUp() {
		System.out.println("Before Bean Generation");
	}
	
	@PreDestroy
	public void endUp() {
		System.out.println("After the bean creation and retreive");
	}
}

package com.springannotation.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // @Component("tennisComponent")
public class TennisCoach implements Coach {


	private FortuneService fortuneService;

	//@Autowired
	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Daily practice backhand volley";
	}

	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}

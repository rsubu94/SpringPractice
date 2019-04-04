package com.spring.withoutxml;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

	private FortuneService fortuneService;
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Swim 1000 meters as warmup";
	}

}

package com.practice.spring;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	// add new fields for emailAddress and team

	private String emailAddress;
	private String team;

	public CricketCoach() {
		System.out.println("CricketCoach : inside no-arg constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Cricket dailyworkout";
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach : inside email address setter method ");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach : inside team setter method ");
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach : inside setter method ");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return "Cricket Fortune : " + fortuneService.getFortune();
	}

}

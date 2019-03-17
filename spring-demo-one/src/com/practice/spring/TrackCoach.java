package com.practice.spring;

public class TrackCoach implements Coach {

	private FortuneService fortuneSerice;

	public TrackCoach() {
	}

	public TrackCoach(FortuneService fortuneSerice) {
		this.fortuneSerice = fortuneSerice;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do it " + fortuneSerice.getFortune();
	}
	
	//add an init-method
	public void startUpStuff() {
		System.out.println("TrackCoach : inside method startUpStuff");
	}
	
	public void doDestroyStuff() {
		System.out.println("TrackCoach : inside method doDestroyStuff");
	}
	
	//add an destroy method
}

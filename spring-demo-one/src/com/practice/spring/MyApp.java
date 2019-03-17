package com.practice.spring;

public class MyApp {
	public static void main(String[] args) {
		Coach baseballCoach = new BaseballCoach();
		System.err.println(baseballCoach.getDailyWorkout());

		Coach trackCoach = new TrackCoach();
		System.out.println(trackCoach.getDailyWorkout());
	}
}

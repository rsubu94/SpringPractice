package com.springannotation.practice;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "DailyFortune method from RESTFortuneservice";
	}

}

package com.springannotation.practice;

import org.springframework.stereotype.Component;

@Component

public class HappyFortuneService implements FortuneService{

	@Override
	public String getDailyFortune() {
		return "Today HappyFortune is lucky day";
	}

}

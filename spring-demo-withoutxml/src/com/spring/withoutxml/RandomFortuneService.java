package com.spring.withoutxml;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	String[] strArr = { "Jon", "Sansa", "Arya", "Daenrys" };

	private Random random = new Random();

	@Override
	public String getDailyFortune() {

		int index = random.nextInt(strArr.length);

		return strArr[index];
	}

}

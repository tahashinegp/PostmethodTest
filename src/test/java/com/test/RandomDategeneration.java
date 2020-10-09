package com.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RandomDategeneration {
	
	public static LocalDate generateDate() {
		
		 LocalDate start = LocalDate.of(2020, Month.JANUARY, 1);
		 long days = ChronoUnit.DAYS.between(start, LocalDate.now());
		 LocalDate randomdate = start.plusDays(new Random().nextInt((int) days + 1));
		return randomdate;
	}

}

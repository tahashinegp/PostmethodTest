package com.test;

import java.time.LocalDate;

public class GenerateRandomDate {
	
	  public static int createRandomIntBetween(int start, int end) {
	        return start + (int) Math.round(Math.random() * (end - start));
	    }

	    public static LocalDate createRandomDate(int startYear, int endYear) {
	        int day = createRandomIntBetween(1, 28);
	        int month = createRandomIntBetween(1, 12);
	        int year = createRandomIntBetween(startYear, endYear);
	        return LocalDate.of(year, month, day);
	    }
	    

}

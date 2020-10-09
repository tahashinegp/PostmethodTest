package com.test;

import java.util.Date;

public class ConverDate{
	static long epochdate;
	public static long convertDate(Date date) {
		// TODO Auto-generated method stub
		epochdate = date.getTime()/1000L;
		return epochdate;
	}

}

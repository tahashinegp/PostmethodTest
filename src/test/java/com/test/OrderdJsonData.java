package com.test;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class OrderdJsonData {
	
	public static long date;
	public  FileWriter filewriter ;
	public static int money=10;
	public String currency;
	public String account_id;
	public static JSONObject staementobjfull = new JSONObject();

	public static JSONObject preapeareJsondata() throws Exception {
		//for generating dynamic epoch date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		JSONObject jsonData=null;
		JSONArray jsonarr=new JSONArray();
		// creating dynamic jsonobject
		for(int i=0; i<16; i++) {
			LinkedHashMap<String,Object> myLinkedHashMap = new LinkedHashMap<String,Object>();
			jsonData=new JSONObject();
			String k = Integer.toString(i);
			//Generate random Date
			LocalDate randomDate = RandomDategeneration.generateDate();
			java.util.Date yourDate = sdf.parse(randomDate.toString());
			//Converting to epoch date
			date= ConverDate.convertDate(yourDate);
			money*=i;
			String amount = Integer.toString(money);
			//orderd json dat
				myLinkedHashMap.put("accound_id",k );
				myLinkedHashMap.put("ammount",amount);
				myLinkedHashMap.put("currency","euro");
				myLinkedHashMap.put("date",date );
				System.out.println(myLinkedHashMap);
				//
				jsonarr.add(myLinkedHashMap);
			
				System.out.println(jsonarr);
//orderd json data finish
		}
		
		staementobjfull.put("statement", jsonarr);
		System.out.println(staementobjfull);
		
		return staementobjfull;
		
	}
	
	/*public static void addHashmap(ArrayList<LinkedHashMap<String,Object>> arraylist) {
	
		
		
	}*/

}

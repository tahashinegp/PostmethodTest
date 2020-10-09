package com.test;

import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class UnorderdJsonData {
	public static long date;
	public  FileWriter filewriter ;
	public static int money=10;
	public String currency;
	public String account_id;
	public static JSONObject staementobjfull=new JSONObject();

	public static JSONObject preapeareJsondata(Boolean order) throws Exception {
		//for generating dynamic epoch date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LinkedHashMap<String,Object> myLinkedHashMap = new LinkedHashMap<String,Object>();
		JSONArray jsonarr=new JSONArray();
		JSONObject jsonData=null;
		// creating dynamic jsonobject
		for(int i=0; i<16; i++) {
			jsonData=new JSONObject();
			String k = Integer.toString(i);
			//Generate random Date
			LocalDate randomDate = RandomDategeneration.generateDate();
			java.util.Date yourDate = sdf.parse(randomDate.toString());
			//Converting to epoch date
			date= ConverDate.convertDate(yourDate);
			String amount = Integer.toString(money);
			//unordered json data
			
				//enter duplicate record
				if(i==5 || i==8) {
					jsonData.accumulate("account_id", "1");
					jsonData.accumulate("ammount", money);
					jsonData.accumulate("currency", "euro");
					jsonData.accumulate("date", date);
				}
				//enter negative balance
				else if(i==10 || i==11) {
					//override money
					int negmoney= -10*3;
					//negative amount
					String negamount = Integer.toString(negmoney);
					jsonData.accumulate("account_id", "1");
					jsonData.accumulate("ammount", negmoney);
					jsonData.accumulate("currency", "euro");
					jsonData.accumulate("date", date);
				}
				else {
					jsonData.accumulate("account_id", k);
					jsonData.accumulate("ammount", money);
					jsonData.accumulate("currency", "euro");
					jsonData.accumulate("date", date);
					
				}
				System.out.println(jsonData);
				jsonarr.put(jsonData);
				staementobjfull.put("statement", jsonarr);
				System.out.println(staementobjfull);
			}
		
		return staementobjfull;
		
	}

}

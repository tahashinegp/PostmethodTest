package com.test;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileWriter;
import org.json.simple.JSONObject;

import org.junit.Test;

public class Test01Api {
	public long date;
	public  FileWriter filewriter ;
	public int money=10;
	public String currency;
	public String account_id;

	@Test
	public void orderedJsontest() throws Exception {
		// TODO Auto-generated method stub
				File file = new File("src/test/resources/ordered.json");
				JSONObject staementobjorderd = new JSONObject();
			
				// creating dynamic jsonobject
				staementobjorderd= OrderdJsonData.preapeareJsondata();
				System.out.println(staementobjorderd);
		    	filewriter = new FileWriter(file);
		    	filewriter.write(staementobjorderd.toString());
		    	filewriter.close();
		    	
		    	given().contentType("application/json").body(staementobjorderd).when().request("POST","/statements").then()
		    	.statusCode(204);
		    	OrderdJsonData.staementobjfull=null;
		
	}
}

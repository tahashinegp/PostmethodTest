package com.test;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class TestApi extends Utils{
	
	
	public long date;
	public  FileWriter filewriter ;
	public int money=10;
	public String currency;
	public String account_id;
	
	//unordered json
	@Test
	public void unorderedJsontest() throws Exception {
		// TODO Auto-generated method stub
				File file = new File("src/test/resources/output.json");
				JSONObject staementobjfull=new JSONObject();
			
				// creating dynamic jsonobject
				staementobjfull= UnorderdJsonData.preapeareJsondata(false);
				
				System.out.println(staementobjfull);
		    	filewriter = new FileWriter(file);
		    	filewriter.write(staementobjfull.toString());
		    	filewriter.close();
		    	
		    	given().contentType("application/json").body(staementobjfull).when().request("POST","/statements").then()
		    	.statusCode(204);
		    	UnorderdJsonData.staementobjfull=null;
		
	}
	
	

}

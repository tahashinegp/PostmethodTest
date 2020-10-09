package com.test;




import org.junit.BeforeClass;

import io.restassured.RestAssured;
public class Utils {

	  //Global Setup Variables
    public static String path;
    public static String jsonPathTerm;

    @BeforeClass
	public static void setup() {

		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(9999);
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

		String baseHost = System.getProperty("server.host");
		if (baseHost == null) {
			baseHost = "http://localhost";
		}
		RestAssured.baseURI = baseHost;
	}


	  
}

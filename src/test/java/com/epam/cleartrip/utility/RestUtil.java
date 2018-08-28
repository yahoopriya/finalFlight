package com.epam.cleartrip.utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtil {

	PropertyFileReader reader = new PropertyFileReader();

	public int verifyresponse() {
		reader.propertyFileLoader();
		RestAssured.baseURI = reader.property.getProperty("URL");
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.get();
		int statuscode = response.statusCode();
	    // System.out.println(response.getHeaders());
		return statuscode;
	}

	public static void main(String[] args) {
		RestUtil restobj = new RestUtil();
		//restobj.verifyresponse();
		
	}
}

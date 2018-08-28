package com.epam.cleartrip.data;

import com.epam.cleartrip.utility.JsonDataReader;

public class TripBooking {

	private String date;

	private String fdest;

	private String tolocation;

	private String useremailid;

	private String title;

	private String uName;

	private String uLastName;

	private String umobileNo;

	private String adultCount;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;

	}

	public String getFdest() {
		return fdest;
	}

	public void setFdest(String fdest) {
		this.fdest = fdest;
	}

	public String getTolocation() {
		return tolocation;
	}

	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}

	public String getUseremailid() {
		return useremailid;
	}

	public void setUseremailid(String useremailid) {
		this.useremailid = useremailid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuLastName() {
		return uLastName;
	}

	public void setuLastName(String uLastName) {
		this.uLastName = uLastName;
	}

	public String getUmobileNo() {
		return umobileNo;
	}

	public void setUmobileNo(String umobileNo) {
		this.umobileNo = umobileNo;
	}

	public String getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(String adultCount) {
		this.adultCount = adultCount;
	}

	public static TripBooking dataProvider() {
		 TripBooking booking = new TripBooking();     
		 booking.setDate(JsonDataReader.dataContext.get("date"));
		 booking.setAdultCount(JsonDataReader.dataContext.get("adultCount"));
		 booking.setFdest(JsonDataReader.dataContext.get("fdest"));
		 booking.setTolocation(JsonDataReader.dataContext.get("tolocation"));
		 booking.setTitle(JsonDataReader.dataContext.get("title"));
		 booking.setuLastName(JsonDataReader.dataContext.get("uName"));
		 booking.setuName(JsonDataReader.dataContext.get("uLastName"));
		 booking.setUmobileNo(JsonDataReader.dataContext.get("umobileNo"));
		 booking.setUseremailid(JsonDataReader.dataContext.get("useremailid"));
		 return booking;
	}	
}